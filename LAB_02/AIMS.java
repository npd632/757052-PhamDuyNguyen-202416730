import java.util.*;

public class AIMS {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1  = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2  = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3  = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        DigitalVideoDisc dvd4  = new DigitalVideoDisc("Christopher Nolan", "Science Fiction", "Inception", 29.99f);
        DigitalVideoDisc dvd5  = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 22.99f);
        DigitalVideoDisc dvd6  = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 25.99f);
        DigitalVideoDisc dvd7  = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 27.99f);
        DigitalVideoDisc dvd8  = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 20.99f);
        DigitalVideoDisc dvd9  = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 23.99f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 21.99f);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 19.99f);
        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowskis", 136, 18.99f);
        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 22.99f);
        DigitalVideoDisc dvd14 = new DigitalVideoDisc("Jurassic Park", "Science Fiction", "Steven Spielberg", 127, 24.99f);
        DigitalVideoDisc dvd15 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 19.99f);
        DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 26.99f);
        DigitalVideoDisc dvd17 = new DigitalVideoDisc("Harry Potter and the Sorcerer's Stone", "Fantasy", "Chris Columbus", 152, 21.99f);
        DigitalVideoDisc dvd18 = new DigitalVideoDisc("The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 178, 29.99f);
        DigitalVideoDisc dvd19 = new DigitalVideoDisc("The Dark Knight Rises", "Action", "Christopher Nolan", 165, 24.99f);
        DigitalVideoDisc dvd20 = new DigitalVideoDisc("Inglourious Basterds", "War", "Quentin Tarantino", 153, 22.99f);

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String username = "";

        DigitalVideoDisc[] store = {
            dvd1, dvd2, dvd3, dvd4, dvd5,
            dvd6, dvd7, dvd8, dvd9, dvd10,
            dvd11, dvd12, dvd13, dvd14, dvd15,
            dvd16, dvd17, dvd18, dvd19, dvd20
        };

        // Assign creation times
        for (int i = 0; i < store.length; i++) {
            store[i].setCreatedTime(i + 1);
        }

        System.out.println("Welcome to AIMS!");
        System.out.println("1. Log in");
        System.out.println("2. Browse as guest");
        System.out.print("Select option: ");
        int loginOption = scanner.nextInt();
        scanner.nextLine();

        if (loginOption == 1) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            scanner.nextLine();
            loggedIn = true;
        } else {
            username = "Guest";
        }

        while (true) {
            // Interface 1: List all DVDs
            System.out.println("\n--- DVD Store ---");
            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1) + ". " + store[i].getTitle());
            }
            System.out.println("...");
            System.out.println("\nOptions:");
            System.out.println("1. Search for DVDs");
            System.out.println("2. View current cart");
            System.out.println("3. Quit");
            System.out.print("Select option: ");
            int mainOption = scanner.nextInt();
            scanner.nextLine();

            if (mainOption == 1) {
                // Interface 2: Searching
                while (true) {
                    System.out.println("\nSearch by:");
                    System.out.println("1. Title");
                    System.out.println("2. Category");
                    System.out.println("3. Price");
                    System.out.println("0. Back");
                    System.out.print("Select option: ");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine();
                    List<DigitalVideoDisc> results = new ArrayList<>();
                    if (searchOption == 1) {
                        System.out.print("Enter keywords: ");
                        String[] keywords = scanner.nextLine().toLowerCase().split("\\s+");
                        for (DigitalVideoDisc dvd : store) {
                            for (String kw : keywords) {
                                if (dvd.getTitle().toLowerCase().contains(kw)) {
                                    results.add(dvd);
                                    break;
                                }
                            }
                        }
                    } else if (searchOption == 2) {
                        System.out.print("Enter category (Action, Animation, Crime, Drama, Fantasy, Romance, Science Fiction, War): ");
                        String category = scanner.nextLine().toLowerCase();
                        for (DigitalVideoDisc dvd : store) {
                            if (dvd.getCategory().toLowerCase().equals(category)) {
                                results.add(dvd);
                            }
                        }
                    } else if (searchOption == 3) {
                        System.out.print("Enter min price (or leave blank): ");
                        String minStr = scanner.nextLine();
                        float min = 0f;
                        if (!minStr.isEmpty()) min = Float.parseFloat(minStr);
                        System.out.print("Enter max price: ");
                        float max = Float.parseFloat(scanner.nextLine());
                        for (DigitalVideoDisc dvd : store) {
                            if (dvd.getCost() >= min && dvd.getCost() <= max) {
                                results.add(dvd);
                            }
                        }
                    } else if (searchOption == 0) {
                        break;
                    } else {
                        continue;
                    }
                    if (results.isEmpty()) {
                        System.out.println("No DVDs found.");
                        continue;
                    }
                    searchResult:
                    while (true) {
                        System.out.println("\nSearch Results:");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.println((i + 1) + ". " + results.get(i).getTitle());
                        }
                        System.out.println("0. Back");
                        System.out.print("Select DVD index to view details: ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        if (idx == 0) break;
                        if (idx < 1 || idx > results.size()) continue;
                        DigitalVideoDisc selected = results.get(idx - 1);
                        System.out.println(selected.getAllInfo());
                        System.out.print("Add this disc to cart? (y/n): ");
                        String add = scanner.nextLine();
                        if (add.equalsIgnoreCase("y")) {
                            boolean alreadyInCart = false;
                            for (DigitalVideoDisc dvd : anOrder.getItemsOrdered()) {
                                if (dvd != null && dvd.equals(selected)) {
                                    alreadyInCart = true;
                                    break;
                                }
                            }
                            if (alreadyInCart) {
                                System.out.println("Disc already added to cart");
                                try { Thread.sleep(1500); } catch (InterruptedException e) {}
                                continue searchResult;
                            } else {
                                anOrder.addDigitalVideoDisc(selected);
                                System.out.println("Returning to search result...");
                                try { Thread.sleep(2000); } catch (InterruptedException e) {}
                                continue searchResult;
                            }
                        }
                    }
                }
            } else if (mainOption == 2) {
                // Interface 3: Cart
                if (anOrder.getQtyOrdered() == 0) {
                    System.out.println("Your cart is empty.");
                    System.out.println("Returning to main menu...");
                    try { Thread.sleep(2000); } catch (InterruptedException e) {}
                    continue;
                }
                while (true) {
                    System.out.println("\n--- Your Cart ---");
                    DigitalVideoDisc[] cartItems = anOrder.getItemsOrdered();
                    float total = 0f;
                    for (int i = 0; i < cartItems.length; i++) {
                        DigitalVideoDisc dvd = cartItems[i];
                        if (dvd != null) {
                            System.out.println((i + 1) + ". " + dvd.getAllInfo());
                            total += dvd.getCost();
                        }
                    }
                    System.out.println("Total cost: $" + String.format("%.2f", total));
                    System.out.println("\nOptions:");
                    System.out.println("1. See a demo of a DVD");
                    System.out.println("2. Sort cart");
                    System.out.println("3. Remove DVD from cart");
                    System.out.println("4. Filter DVD");
                    System.out.println("5. Place order");
                    System.out.println("0. Back");
                    System.out.print("Select option: ");
                    int cartOption = scanner.nextInt();
                    scanner.nextLine();
                    if (cartOption == 1) {
                        System.out.print("Enter DVD index to demo: ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        if (idx >= 1 && idx <= cartItems.length) {
                            System.out.println("Now playing demo of: " + cartItems[idx - 1].getTitle() + "...");
                            try { Thread.sleep(2000); } catch (InterruptedException e) {}
                        }
                    } else if (cartOption == 2) {
                        System.out.println("Sort by: 1. Title 2. Cost");
                        int sortOpt = scanner.nextInt();
                        scanner.nextLine();
                        if (sortOpt == 1) {
                            anOrder.sortByTitle();
                        } else if (sortOpt == 2) {
                            anOrder.sortByCost();
                        }
                    } else if (cartOption == 3) {
                        System.out.print("Enter DVD index to remove: ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        if (idx >= 1 && idx <= cartItems.length) {
                            anOrder.removeDigitalVideoDisc(cartItems[idx - 1]);
                        }
                    } else if (cartOption == 4) {
                        System.out.println("Filter by: 1. Title 2. Index");
                        int filterOpt = scanner.nextInt();
                        scanner.nextLine();
                        List<DigitalVideoDisc> filtered = new ArrayList<>();
                        if (filterOpt == 1) {
                            System.out.print("Enter title keyword: ");
                            String kw = scanner.nextLine().toLowerCase();
                            for (DigitalVideoDisc dvd : cartItems) {
                                if (dvd != null && dvd.getTitle().toLowerCase().contains(kw)) {
                                    filtered.add(dvd);
                                }
                            }
                        } else if (filterOpt == 2) {
                            System.out.print("Enter index: ");
                            int idx = scanner.nextInt();
                            scanner.nextLine();
                            if (idx >= 1 && idx <= cartItems.length && cartItems[idx - 1] != null) {
                                filtered.add(cartItems[idx - 1]);
                            }
                        }
                        filtered.removeIf(Objects::isNull);
                        if (filtered.isEmpty()) {
                            System.out.println("No DVDs found.");
                            continue;
                        }
                        while (true) {
                            for (int i = 0; i < filtered.size(); i++) {
                                DigitalVideoDisc dvd = filtered.get(i);
                                if (dvd != null) {
                                    System.out.println((i + 1) + ". " + dvd.getAllInfo());
                                }
                            }
                            System.out.println("Options: 1. View demo 2. Remove from cart 0. Back");
                            int fOpt = scanner.nextInt();
                            scanner.nextLine();
                            if (fOpt == 1) {
                                System.out.print("Enter index: ");
                                int idx = scanner.nextInt();
                                scanner.nextLine();
                                if (idx >= 1 && idx <= filtered.size() && filtered.get(idx - 1) != null) {
                                    System.out.println("Now playing demo of: " + cartItems[idx - 1].getTitle() + "...");
                                    try { Thread.sleep(2000); } catch (InterruptedException e) {}
                                }
                            } else if (fOpt == 2) {
                                System.out.print("Enter index: ");
                                int idx = scanner.nextInt();
                                scanner.nextLine();
                                if (idx >= 1 && idx <= filtered.size() && filtered.get(idx - 1) != null) {
                                    anOrder.removeDigitalVideoDisc(filtered.get(idx - 1));
                                    filtered.remove(idx - 1);
                                }
                            } else {
                                break;
                            }
                        }
                    } else if (cartOption == 5) {
                        String orderName = username;
                        if (!loggedIn) {
                            System.out.print("Enter your name: ");
                            orderName = scanner.nextLine();
                        }
                        System.out.print("Enter phone number: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter delivery address: ");
                        String address = scanner.nextLine();
                        Date now = new Date();
                        float beforeVAT = total;
                        float afterVAT = beforeVAT * 1.1f;
                        float deliveryFee = 5.0f;
                        System.out.println("\n--- BILL ---");
                        System.out.println("Name: " + orderName);
                        System.out.println("Phone: " + phone);
                        System.out.println("Address: " + address);
                        System.out.println("Date: " + now);
                        for (DigitalVideoDisc dvd : cartItems) {
                            if (dvd != null) {
                                System.out.println(dvd.getAllInfo());
                            }
                        }
                        System.out.println("Total before VAT: $" + String.format("%.2f", beforeVAT));
                        System.out.println("Total after VAT: $" + String.format("%.2f", afterVAT));
                        System.out.println("Delivery fee: $" + String.format("%.2f", deliveryFee));
                        System.out.println("Payment method: Credit Card");
                        System.out.println("1. Visa\n2. MasterCard");
                        int cardType = scanner.nextInt();
                        scanner.nextLine();
                        String cardTypeStr = (cardType == 1) ? "Visa" : (cardType == 2) ? "MasterCard" : "Unknown";
                        System.out.print("Enter card number: ");
                        String cardNumber = scanner.nextLine();
                        System.out.println("Processing payment...");
                        try { Thread.sleep(2000); } catch (InterruptedException e) {}
                        System.out.println("\n--- RECEIPT ---");
                        System.out.println("Name: " + orderName);
                        System.out.println("Phone: " + phone);
                        System.out.println("Address: " + address);
                        System.out.println("Date: " + now);
                        System.out.println("Payment method: " + cardTypeStr);
                        System.out.println("Card number: " + cardNumber);
                        for (DigitalVideoDisc dvd : cartItems) {
                            if (dvd != null) {
                                System.out.println(dvd.getAllInfo());
                            }
                        }
                        System.out.println("Total before VAT: $" + String.format("%.2f", beforeVAT));
                        System.out.println("Total after VAT: $" + String.format("%.2f", afterVAT));
                        System.out.println("Delivery fee: $" + String.format("%.2f", deliveryFee));
                        System.out.println("Your order is in pending state. Please check your email for the information of the order & the transaction.");
                        System.out.println("\nThank you for using AIMS!");
                        System.exit(0);
                    } else if (cartOption == 0) {
                        break;
                    }
                }
            } else if (mainOption == 3) {
                System.out.println("Thank you for using AIMS!");
                break;
            }
        }
        scanner.close();
    }
}