package aims;
import java.util.*;
import aims.cart.Cart;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Track;
import aims.store.Store;

public class AIMS {

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        // Options
        System.out.println("Store Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Media Details Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof DigitalVideoDisc) {
            System.out.println("2. Play DVD");
            System.out.println("0. Back");
        } else if (media instanceof CompactDisc) {
            System.out.println("2. Play CD");
            System.out.println("0. Back");
        } else {
            System.out.println("0. Back");
        }
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Cart Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void sortMenu() {
        System.out.println("Sorting Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void filterMenu() {
        System.out.println("Filter Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void main(String[] args) {

        DigitalVideoDisc dvd1  = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2  = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3  = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        CompactDisc cd1 = new CompactDisc("Hybrid Theory", "Rock", "Linkin Park", 15.99f, "Chester Bennington");
        cd1.addTrack(new Track("Papercut", 185));
        cd1.addTrack(new Track("One Step Closer", 155));
        cd1.addTrack(new Track("With You", 200));
        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", "AC/DC", 14.99f, "Brian Johnson");
        cd2.addTrack(new Track("Hells Bells", 312));
        cd2.addTrack(new Track("Shoot to Thrill", 315));
        CompactDisc cd3 = new CompactDisc("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 16.99f, "David Gilmour");
        cd3.addTrack(new Track("Speak to Me", 90));
        cd3.addTrack(new Track("Breathe", 163));

        Book book1 = new Book("The Great Gatsby", "Fiction", 10.99f);
        book1.addAuthor("F. Scott Fitzgerald");
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        book2.addAuthor("George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Fiction", 12.99f);
        book3.addAuthor("Harper Lee");

        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        cart.addMedia(dvd1);    // Pre-add some items for testing
        cart.addMedia(cd1);
        cart.addMedia(book1);

        Store store = new Store();
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        while (true) {
            showMenu();
            int choice = -1;
            try { choice = Integer.parseInt(scanner.nextLine().trim()); } catch (Exception e) { choice = -1; }

            if (choice == 0) {
                System.out.println("Exiting the application.");
                break;
            }

            if (choice == 1) { // View store
                boolean backToMain = false;
                while (!backToMain) {
                    store.printStore(); // Display store
                    storeMenu();
                    int storeChoice = -1;
                    storeChoice = Integer.parseInt(scanner.nextLine().trim());

                    switch (storeChoice) {
                        case 0:
                            backToMain = true;
                            break;
                        case 1: { // See a media's details
                            System.out.print("Enter the media's title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("Media not found");
                                break;
                            } else {
                                System.out.println(found.getAllInfo());
                            }
                            mediaDetailsMenu(found);
                            int mdChoice = -1;
                            mdChoice = Integer.parseInt(scanner.nextLine().trim());
                            if (mdChoice == 1) {
                                cart.addMedia(found);
                            } else if (mdChoice == 2) {
                                found.play();
                            } // 0 or others -> just return to store menu
                            break;
                        }
                        case 2: { // Add a media to cart
                            System.out.print("Enter the media's title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("Media not found");
                                break;
                            } else {
                                cart.addMedia(found);
                                System.out.println("Number of items in cart: " + cart.getQtyOrdered() + "");
                            }
                            break;
                        }
                        case 3: { // Play a media
                            System.out.print("Enter the media's title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("Media not found");
                            } else {
                                found.play();
                            }
                            break;
                        }
                        case 4: { // See current cart
                            boolean backToStore = false;
                            while (!backToStore) {
                                cart.printCart();
                                cartMenu();
                                int cartChoice = -1;
                                cartChoice = Integer.parseInt(scanner.nextLine().trim());
                                switch (cartChoice) {
                                    case 0:
                                        backToStore = true;
                                        break;
                                    case 1: { // Filter medias in cart
                                        while (true) {
                                            filterMenu();
                                            int filterChoice = -1;
                                            filterChoice = Integer.parseInt(scanner.nextLine().trim());
                                            if (filterChoice == 0) {
                                                break;
                                            } else if (filterChoice == 1) {
                                                System.out.print("Enter title to filter: ");
                                                String title = scanner.nextLine().trim();
                                                cart.filterByTitle(title);
                                            } else if (filterChoice == 2) {
                                                System.out.print("Enter ID to filter: ");
                                                int id = Integer.parseInt(scanner.nextLine().trim());
                                                cart.filterById(id);
                                            } else {
                                                System.out.println("Invalid option. Please choose 0-1-2.");
                                            }
                                        }
                                        break;
                                    }
                                    case 2: { // Sort medias in cart
                                        while (true) {
                                            sortMenu();
                                            int sortChoice = -1;
                                            sortChoice = Integer.parseInt(scanner.nextLine().trim());
                                            if (sortChoice == 0) {
                                                break;
                                            } else if (sortChoice == 1) {
                                                cart.sortByTitle();
                                                System.out.println("Cart sorted by title.");
                                                break;
                                            } else if (sortChoice == 2) {
                                                cart.sortByCost();
                                                System.out.println("Cart sorted by cost.");
                                                break;
                                            } else {
                                                System.out.println("Invalid option. Please choose 0-1-2.");
                                            }
                                        }
                                    }
                                    case 3: { // Remove media from cart
                                        System.out.print("Enter the media's title to remove: ");
                                        String title = scanner.nextLine().trim();
                                        Media found = null;
                                        found = store.findMediaByTitle(title, store);
                                        if (found == null) {
                                            System.out.println("Media not found");
                                        } else {
                                            cart.removeMedia(found);
                                            System.out.println("Number of items in cart: " + cart.getQtyOrdered() + "");
                                        }
                                        break;
                                    }
                                    case 4: { // Play a media
                                        System.out.print("Enter the media's title: ");
                                        String title = scanner.nextLine().trim();
                                        Media found = null;
                                        found = store.findMediaByTitle(title, store);
                                        if (found == null) {
                                            System.out.println("Media not found");
                                        } else {
                                            found.play();
                                        }
                                        break;
                                    }
                                    case 5: { // Place order
                                        System.out.println("Order created. Thank you for your purchase!");
                                        cart.clearCart();
                                        System.out.println("Your cart is now empty.");
                                        break;
                                    }
                                    default:
                                        System.out.println("Invalid option. Please choose 0-1-2-3-4-5.");
                                }
                            }
                            break;
                        }
                        default:
                            System.out.println("Invalid option. Please choose 0-1-2-3-4.");
                    }
                }
            } else if (choice == 2) { // Update store
                System.out.println("Feature not yet available");
                break;
            } else if (choice == 3) { // See current cart
                boolean backToMain = false;
                while (!backToMain) {
                    cartMenu();
                    int cartChoice = -1;
                    cartChoice = Integer.parseInt(scanner.nextLine().trim());
                    switch (cartChoice) {
                        case 0:
                            backToMain = true;
                            break;
                        case 1: { // Filter medias in cart
                            while (true) {
                                filterMenu();
                                int filterChoice = -1;
                                filterChoice = Integer.parseInt(scanner.nextLine().trim());
                                if (filterChoice == 0) {
                                    break;
                                } else if (filterChoice == 1) {
                                    System.out.print("Enter title to filter: ");
                                    String title = scanner.nextLine().trim();
                                    cart.filterByTitle(title);
                                } else if (filterChoice == 2) {
                                    System.out.print("Enter ID to filter: ");
                                    int id = Integer.parseInt(scanner.nextLine().trim());
                                    cart.filterById(id);
                                } else {
                                    System.out.println("Invalid option. Please choose 0-1-2.");
                                }
                            }
                            break;
                        }
                        case 2: { // Sort medias in cart
                            while (true) {
                                sortMenu();
                                int sortChoice = -1;
                                sortChoice = Integer.parseInt(scanner.nextLine().trim());
                                if (sortChoice == 0) {
                                    break;
                                } else if (sortChoice == 1) {
                                    cart.sortByTitle();
                                    System.out.println("Cart sorted by title.");
                                    break;
                                } else if (sortChoice == 2) {
                                    cart.sortByCost();
                                    System.out.println("Cart sorted by cost.");
                                    break;
                                } else {
                                    System.out.println("Invalid option. Please choose 0-1-2.");
                                }
                            }
                        }
                        case 3: { // Remove media from cart
                            System.out.print("Enter the media's title to remove: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("Media not found");
                            } else {
                                cart.removeMedia(found);
                                System.out.println("Number of items in cart: " + cart.getQtyOrdered() + "");
                            }
                            break;
                        }
                        case 4: { // Play a media
                            System.out.print("Enter the media's title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("Media not found");
                            } else {
                                found.play();
                            }
                            break;
                        }
                        case 5: { // Place order
                            System.out.println("Order created. Thank you for your purchase!");
                            cart.clearCart();
                            System.out.println("Your cart is now empty.");
                            break;
                        }
                        default:
                            System.out.println("Invalid option. Please choose 0-1-2-3-4-5.");
                    }
                }
            } else {
                System.out.println("Invalid option. Please choose 0-1-2-3.");
            }
        }
        scanner.close();
    }
}