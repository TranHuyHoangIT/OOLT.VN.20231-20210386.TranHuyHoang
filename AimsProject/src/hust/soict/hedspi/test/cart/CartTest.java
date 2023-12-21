package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) throws Exception {
		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Aliers", 87, 19.95f);
		cart.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);
		cart.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Geore Lucas", 87, 18.99f);
		cart.addMedia(dvd3);
	}

}
