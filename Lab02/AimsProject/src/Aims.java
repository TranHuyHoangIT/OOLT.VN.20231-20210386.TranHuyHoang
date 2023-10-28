
public class Aims {
	
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion king", "Animation", "Roger Aliers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
	
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Geore Lucas", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.displayCart();
		
		anOrder.removeDigitalVideoDisc(dvd3);
		anOrder.displayCart();
		
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.displayCart();
	}
	
}