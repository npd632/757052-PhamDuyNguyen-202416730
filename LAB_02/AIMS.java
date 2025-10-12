import java.util.Scanner;

public class AIMS {
    public static void main(String[] args) {
        // Create new cart
        Cart anOrder = new Cart();

        Scanner scanner = new Scanner(System.in);
        boolean shopping = true;

        while (shopping) {
            System.out.println("AIMS Shopping Cart Menu:");
            System.out.println("1. Add new disc");
            System.out.println("2. Remove disc");
            System.out.println("3. Modify cart");
            System.out.println("4. Finish shopping");
            System.out.print("Choose an action (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    if (title.isEmpty()) break;

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    if (category.isEmpty()) break;

                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    if (director.isEmpty()) break;

                    System.out.print("Enter length: ");
                    String lengthStr = scanner.nextLine();
                    if (lengthStr.isEmpty()) break;
                    int length = Integer.parseInt(lengthStr);

                    System.out.print("Enter cost: ");
                    String costStr = scanner.nextLine();
                    if (costStr.isEmpty()) break;
                    float cost = Float.parseFloat(costStr);

                    // Assuming DigitalVideoDisc class exists
                    DigitalVideoDisc disc = new DigitalVideoDisc(title, category, director, length, cost);
                    anOrder.addDigitalVideoDisc(disc);
                    System.out.println("Disc added to cart.");
                    break;
                case 2:
                    // Remove disc logic here
                    System.out.println("Removing disc...");
                    break;
                case 3:
                    // Modify cart logic here
                    System.out.println("Modifying cart...");
                    break;
                case 4:
                    System.out.println("Finishing shopping. Thank you!");
                    shopping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
        scanner.close();
    }
}