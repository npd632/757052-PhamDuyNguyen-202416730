package aims.store;
import java.util.ArrayList;

import aims.media.DigitalVideoDisc;
import aims.media.Media;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public static int qtyInStore = 0;

    public void addMedia(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore.add(disc);
            qtyInStore++;
            System.out.println("'" + disc.getTitle() + "'" + " has been added to store.");
        } else {
            System.out.println("Store is full. Cannot add DVD.");
        }
    }

    public void removeMedia(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore.get(i).equals(disc)) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore.set(j, itemsInStore.get(j + 1));
                }
                itemsInStore.remove(qtyInStore - 1);
                qtyInStore--;
                System.out.println("'" + disc.getTitle() + "'" + " has been removed from store.");
                return;
            }
        }
        System.out.println("'" + disc.getTitle() + "'" + " not found in store.");
    }

}
