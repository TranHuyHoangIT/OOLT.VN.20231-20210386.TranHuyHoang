package hust.soict.hedspi.aims.screen.customer.controller;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	@FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;
    
	private Media media;
	
	private Cart cart;
	
	@FXML
    void btnAddToCartClicked(ActionEvent event) {
		try {
			cart.addMedia(media);
			JOptionPane.showMessageDialog(null, "The media added to the list", "Success", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
		}
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	if(media instanceof DigitalVideoDisc) {
    		try {
    			DigitalVideoDisc digitalVideoDisc = (DigitalVideoDisc) media;
				digitalVideoDisc.play();
				JOptionPane.showMessageDialog(null, 
						"Playing DVD: " + digitalVideoDisc.getTitle() + 
						"\nDVD length: " + digitalVideoDisc.getLength(),
						"Play DVD", JOptionPane.INFORMATION_MESSAGE);
			} catch (PlayerException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
    	}
    	if(media instanceof CompactDisc) {
    		try {
    			CompactDisc compactDisc = (CompactDisc) media;
				compactDisc.play();
				StringBuilder tracksInfo = new StringBuilder();
				for(Track track : compactDisc.getTrack()) {
					tracksInfo.append("\n").append(track.getTitle()).append(" - Length: ").append(track.getLength());
				}
				JOptionPane.showMessageDialog(null, 
						"Playing CD: " + compactDisc.getTitle() + 
						"\nCD length: " + compactDisc.getLength() +
						tracksInfo,
						"Play CD", JOptionPane.INFORMATION_MESSAGE);
			} catch (PlayerException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
    	}
    }
    
    public ItemController(Cart cart) {
    	this.cart = cart;
    }
    
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost() + " $");
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 110));
		}
	}

}
