package AimsProject.src.aims.store;
import AimsProject.src.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 1000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("'" + disc.getTitle() + "'" + " has been added to store.");
        } else {
            System.out.println("Store is full. Cannot add DVD.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("'" + disc.getTitle() + "'" + " has been removed from store.");
                return;
            }
        }
        System.out.println("'" + disc.getTitle() + "'" + " not found in store.");
    }

}
