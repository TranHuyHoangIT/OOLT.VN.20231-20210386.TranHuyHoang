package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Aliers", 87, 19.95f);
		cart.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);
		cart.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Geore Lucas", 87, 18.99f);
		cart.addMedia(dvd3);

//		cart.printCart();
//		cart.searchDVD(4);
//		cart.searchDVD("Aladingggg");
		
//		Test toString()
//		List<Media> mediae = new ArrayList<Media>();
//		CompactDisc CD = new CompactDisc("CD 1");
//		DigitalVideoDisc DVD = new DigitalVideoDisc("DVD 1");
//		Book book = new Book("Book 1");
//		mediae.add(CD);
//		mediae.add(DVD);
//		mediae.add(book);
//		
//		for(Media media : mediae) {
//			System.out.println(media.toString());
//		}
	}

}
