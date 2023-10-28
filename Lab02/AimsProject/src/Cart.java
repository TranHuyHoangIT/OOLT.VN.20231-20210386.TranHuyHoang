
public class Cart {
	private int qtyOrdered = 0;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		int quantity = this.getQtyOrdered();
		if (quantity >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		} else {
			this.itemsOrdered[quantity] = disc;
			System.out.println("Disc " + disc.getTitle() + " has been added.");
			quantity++;
			this.setQtyOrdered(quantity);
		}
	}
	// Overloading by differing types of parameter
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int length = dvdList.length;
		int quantity = this.getQtyOrdered();
		if(length + quantity > MAX_NUMBERS_ORDERED) {
			System.out.println("Can not add list of DVDs. The cart is almost full");
		}
		else {
			for (int i = 0; i < length; i++) {
	            this.itemsOrdered[quantity] = dvdList[i];
	            System.out.println("Disc " + dvdList[i].getTitle() + " has been added.");
	            quantity++;
	        }
	        this.setQtyOrdered(quantity);
		}
	}
	
//  Try to add method addDigitalVideoDisc (DigitalVideoDisc... dvdList) allows to pass an arbitrary number of arguments for dvd.
//	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
//		int length = dvdList.length;
//		int quantity = this.getQtyOrdered();
//		if(length + quantity > MAX_NUMBERS_ORDERED) {
//			System.out.println("Can not add list of DVDs. The cart is almost full");
//		}
//		else {
//			for (int i = 0; i < length; i++) {
//	            this.itemsOrdered[quantity] = dvdList[i];
//	            System.out.println("Disc " + dvdList[i].getTitle() + " has been added.");
//	            quantity++;
//	        }
//	        this.setQtyOrdered(quantity);
//		}
//	}
	
//  Overloading by differing the number of parameters
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    int quantity = this.getQtyOrdered();

	    if (quantity + 2 > MAX_NUMBERS_ORDERED) {
	        System.out.println("Can not add two DVDs. The cart is almost full.");
	    } else {
	        this.itemsOrdered[quantity] = dvd1;
	        System.out.println("Disc " + dvd1.getTitle() + " has been added.");
	        quantity++;

	        this.itemsOrdered[quantity] = dvd2;
	        System.out.println("Disc " + dvd2.getTitle() + " has been added.");
	        quantity++;

	        this.setQtyOrdered(quantity);
	    }
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	    int quantity = this.getQtyOrdered();    
	    if (quantity <= 0) {
	        System.out.println("The cart is empty!");
	        return;
	    }
	    boolean found = false;
	    DigitalVideoDisc itemsTmpOrdered[] = new DigitalVideoDisc[quantity];
	    int j = 0;
	    
	    for (int i = 0; i < quantity; i++) {
	        if (!this.itemsOrdered[i].getTitle().equals(disc.getTitle())) {
	            itemsTmpOrdered[j] = this.itemsOrdered[i];
	            j++;
	        } else {
	            found = true; 
	        }
	    }
	    if (found) {
	        for (int i = 0; i < quantity; i++) {
	            this.itemsOrdered[i] = itemsTmpOrdered[i];
	        }
	        System.out.println("Disc " + disc.getTitle() + " has been removed.");
	        this.setQtyOrdered(quantity - 1);
	    } else {
	        System.out.println("Disc " + disc.getTitle() + " was not found in the cart.");
	    }
	}
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < this.getQtyOrdered(); i++) {
			total += this.itemsOrdered[i].getCost();
		}
		return total;
	}
	public void displayCart() {
		System.out.println("----------DISPLAY CART----------");
		for (int i = 0; i < this.getQtyOrdered(); i++) {
			String title = this.itemsOrdered[i].getTitle();
			float cost = this.itemsOrdered[i].getCost();
			System.out.printf("%-5d %-20s %.2f%n", i + 1, title, cost);
		}
		System.out.printf("      Total Cost           %.2f\n\n", this.totalCost());
	}
}