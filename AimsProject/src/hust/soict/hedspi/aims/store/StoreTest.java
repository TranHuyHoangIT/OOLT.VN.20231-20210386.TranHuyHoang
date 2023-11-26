package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
	
	public static void main(String[] args) {
		Store store = new Store();

		Media dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Aliers", 87, 19.95f);
		store.addMedia(dvd1);

		Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);
		store.addMedia(dvd2);

		Media dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Geore Lucas", 87, 18.99f);
		store.addMedia(dvd3);
		
		store.removeMedia(dvd2);
		store.removeMedia(dvd2);
	}
}
