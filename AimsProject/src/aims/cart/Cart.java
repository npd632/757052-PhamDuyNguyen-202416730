package aims.cart;
import java.util.ArrayList;
import aims.media.Media;

import aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private int qtyOrdered = 0;
    
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        for (Media item : itemsOrdered) {
            if (item.equals(media)) {
                System.out.println("Item already in cart: " + media.getTitle());
                return;
            }
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            qtyOrdered++;
            System.out.println("Added to cart: " + media.getTitle());
        } else {
            System.out.println("The cart is full. Cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            qtyOrdered--;
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println("Media not found" + media.getTitle());
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("**********************************************CART***********************************************\n Ordered Items:\n");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).getAllInfo());
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("*************************************************************************************************");
    }

    public void sortByTitle() {
        for (int i = 0; i < qtyOrdered - 1; i++) {
            for (int j = i + 1; j < qtyOrdered; j++) {
                if (itemsOrdered.get(i).getTitle().compareTo(itemsOrdered.get(j).getTitle()) > 0) {
                    Media temp = itemsOrdered.get(i);
                    itemsOrdered.set(i, itemsOrdered.get(j));
                    itemsOrdered.set(j, temp);
                }
            }
        }
    }

    public void sortByCost() {
        for (int i = 0; i < qtyOrdered - 1; i++) {
            for (int j = i + 1; j < qtyOrdered; j++) {
                if (itemsOrdered.get(i).getCost() > itemsOrdered.get(j).getCost()) {
                    Media temp = itemsOrdered.get(i);
                    itemsOrdered.set(i, itemsOrdered.get(j));
                    itemsOrdered.set(j, temp);
                }
            }
        }
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void filterByTitle(String title) {
        System.out.println("Filter results for title containing '" + title + "':");
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).getAllInfo());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Media not found");
        }
    }

    public void filterById(int id) {
        System.out.println("Filter results for ID '" + id + "':");
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).getAllInfo());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Media not found");
        }
    }

    public Media[] getItemsOrdered() {
        return itemsOrdered.toArray(new Media[0]);
    }

    public void clearCart() {
        itemsOrdered.clear();
        qtyOrdered = 0;
    }

}
