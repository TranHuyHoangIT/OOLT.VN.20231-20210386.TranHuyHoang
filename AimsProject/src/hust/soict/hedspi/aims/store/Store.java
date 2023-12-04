package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public Store() {
		super();
	}

	public boolean addMedia(Media media) {
    	if (!itemsInStore.contains(media)) {
			itemsInStore.add(media);
			System.out.printf("Item "+ media.getTitle() + " has been added\n");
			return true;
		} else {
			System.out.println("The item is already in store\n");
    		return false;
		}
    }

	public boolean removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("The item does not exist in store");
            return false;
        }
        else {
        	itemsInStore.remove(media);
        	System.out.printf("Item " + media.getTitle() +" has been removed\n");
	        return true;
        }
    }
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
