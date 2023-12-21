package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartScreen extends Application {

	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		CartController cartController = new CartController(cart);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args){
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
