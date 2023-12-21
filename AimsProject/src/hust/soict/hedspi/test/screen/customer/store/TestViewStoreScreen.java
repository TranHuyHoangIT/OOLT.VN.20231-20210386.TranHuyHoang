package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Store store;
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		store = new Store();
		store.addMedia(new DigitalVideoDisc(7, "Harry Potter và Hòn đá Phù thủy (DVD)", "Harry Potter", 15, "J. K. Rowling", 100));
		store.addMedia(new DigitalVideoDisc(8, "Harry Potter và Phòng chứa Bí mật (DVD)", "Harry Potter", 20, "J. K. Rowling", 120));
		store.addMedia(new DigitalVideoDisc(9, "Harry Potter và Chiếc cốc lửa (DVD)", "Harry Potter", 18, "J. K. Rowling", 140));
		store.addMedia(new DigitalVideoDisc(10, "Harry Potter và Hội Phượng Hoàng (DVD)", "Harry Potter", 26, "J. K. Rowling", 115));
		store.addMedia(new DigitalVideoDisc(11, "Harry Potter và Hoàng tử lai (DVD)", "Harry Potter", 35, "J. K. Rowling", 180));
		CompactDisc cd1 = new CompactDisc(12, "CD 1", "Music", 30, "Tran Huy Hoang", 90);
		store.addMedia(cd1);
		CompactDisc cd2 = new CompactDisc(13, "CD 2", "Music", 40, "Tran Huy Hoang", 150);
		store.addMedia(cd2);
		Track track1 = new Track("Track 1", 10);
		Track track2 = new Track("Track 2", 20);
		Track track3 = new Track("Track 3", 30);
		Track track4 = new Track("Track 4", -100);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd2.addTrack(track3);
		cd2.addTrack(track4);
		store.addMedia(new Book(14, "Đại số", "Toán cao cấp", 10));
		store.addMedia(new Book(15, "Giải tích 2", "Toán cao cấp", 15));
		
		cart = new Cart();
		try {
			cart.addMedia(new DigitalVideoDisc(1, "Doraemon", "Anime", 50, "Fujio", 120));
			cart.addMedia(new DigitalVideoDisc(2, "One Piece", "Anime", 75, "Oda", 120));
			cart.addMedia(new CompactDisc(3, "CD 3", "CD", 36, "Tran Huy Hoang", 130));
			cart.addMedia(new CompactDisc(4, "CD 4", "CD", 24, "Tran Huy Hoang", 150));
			cart.addMedia(new Book(5, "Giải tích 1", "Toán cao cấp", 10));
			cart.addMedia(new Book(6, "Xác suất thống kê", "Toán cao cấp", 15));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		launch(args);
	}
}
