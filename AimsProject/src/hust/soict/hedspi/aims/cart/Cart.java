package hust.soict.hedspi.aims.cart;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public boolean addMedia(Media media) throws Exception {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
        	if (!itemsOrdered.contains(media)) {
				itemsOrdered.add(media);
				System.out.printf("The item has been added\n");
				return true;
			} else {
				System.out.println("The item is already in cart\n");
				throw new Exception("ERROR: The item is already in cart");
			}
		}
		else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
	}
	
	public boolean removeMedia(Media media) {
	        if (!itemsOrdered.contains(media)) {
	            System.out.println("The item does not exist in cart\n");
	            return false;
	        }
	        else {
	        	itemsOrdered.remove(media);
	        	System.out.printf("The item has been removed\n");
		        return true;
	        }
	    }
	
	public float totalCost() {
		float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
	}
	
	// Lab 02
	public void displayCart() {
		System.out.println("----------DISPLAY CART----------");
		for (Media media : itemsOrdered) {
			String title = media.getTitle();
			float cost = media.getCost();
			int id = media.getId();
			System.out.printf("%-5d %-20s %.2f%n", id, title, cost);
		}
		System.out.printf("      Total Cost           %.2f\n\n", this.totalCost());
	}
	
	// Lab 03
	public void printCart() {
        System.out.println("***********************CART***********************");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.printf("Total cost: %.2f$\n", totalCost());
        System.out.println("***************************************************\n");
	}
	
	public void searchById(int id) {
		for (Media item : itemsOrdered){
			if (item.getId() == id) {
				System.out.printf(item.toString());
				return;
			}
        }
		System.out.println("Not found");
	}
	
	public void searchByTitle(String title) {
		for (Media item : itemsOrdered) {
			if (item.getTitle().equals(title)) {
				System.out.printf(item.toString());
				return;
			}
		}
		System.out.println("Not found");
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}