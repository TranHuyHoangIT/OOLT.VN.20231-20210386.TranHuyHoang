
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