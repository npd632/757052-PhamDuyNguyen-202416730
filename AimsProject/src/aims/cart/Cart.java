package AimsProject.src.aims.cart;
import AimsProject.src.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("'" + disc.getTitle() + "'" + " has been added to cart.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("Cart is full.");
            }
            else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 5) {
                System.out.println("Cart is almost full.");
            }
        } else {
            System.out.println("Cart is already full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("'" + disc.getTitle() + "'" + " has been removed from cart.");
                if (qtyOrdered == 0) {
                    System.out.println("Cart is now empty.");
                }
                return;
            }
        }
        System.out.println("'" + disc.getTitle() + "'" + " not found in cart.");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("***********************CART***********************\n Ordered Items:\n");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getAllInfo());
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("**************************************************");
    }

    public void sortByTitle() {
        for (int i = 0; i < qtyOrdered - 1; i++) {
            for (int j = i + 1; j < qtyOrdered; j++) {
                if (itemsOrdered[i].getTitle().compareTo(itemsOrdered[j].getTitle()) > 0) {
                    DigitalVideoDisc temp = itemsOrdered[i];
                    itemsOrdered[i] = itemsOrdered[j];
                    itemsOrdered[j] = temp;
                }
            }
        }
    }

    public void sortByCost() {
        for (int i = 0; i < qtyOrdered - 1; i++) {
            for (int j = i + 1; j < qtyOrdered; j++) {
                if (itemsOrdered[i].getCost() > itemsOrdered[j].getCost()) {
                    DigitalVideoDisc temp = itemsOrdered[i];
                    itemsOrdered[i] = itemsOrdered[j];
                    itemsOrdered[j] = temp;
                }
            }
        }
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void searchByTitle(String title) {
        System.out.println("Search results for title containing '" + title + "':");
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println((i + 1) + ". " + itemsOrdered[i].getAllInfo());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found with title containing '" + title + "'.");
        }
    }

    public void searchById(int id) {
        System.out.println("Search results for ID '" + id + "':");
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            if (disc != null && disc.getId() == id) {
            System.out.println((i + 1) + ". " + disc.getAllInfo());
            found = true;
            break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID '" + id + "'.");
        }
    }

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

}
