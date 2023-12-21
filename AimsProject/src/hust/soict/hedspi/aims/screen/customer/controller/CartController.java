package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import javax.swing.JOptionPane;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Store store;
	private Cart cart;
	
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	
	private FilteredList<Media> filteredMediaList;
	
    @FXML
    private TextField tfFilter;
	
    @FXML
    private RadioButton radioBtnFilterId;
	
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TableColumn<Media, Integer> colMediaId;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    private RadioButton lastSelectedRadioButton;
    
	public CartController(Cart cart) {
		this.cart = cart;
	}

	@FXML
	void btnPlayPressed(ActionEvent event) throws PlayerException {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
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
					tracksInfo.append("\n").append(track.getTitle()).append(": ").append(track.getLength());
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    void setTotalCost() {
    	costLabel.setText(cart.totalCost() + " $");
    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	if(cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    		setTotalCost();
    	}
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
		});
    	
    	filteredMediaList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
    	lastSelectedRadioButton = radioBtnFilterId;
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			showFilteredMedia(newValue);
    		}
		});
    	
    	radioBtnFilterId.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                lastSelectedRadioButton = radioBtnFilterId;
                showFilteredMedia(tfFilter.getText());
            }
        });

        radioBtnFilterTitle.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                lastSelectedRadioButton = radioBtnFilterTitle;
                showFilteredMedia(tfFilter.getText());
            }
        });
        
        tblMedia.setItems(filteredMediaList);
        setTotalCost();
    }
    
	void updateButtonBar(Media media) {
		if(media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}
		else {
			btnRemove.setVisible(true);
			if (media instanceof Playable) {
				btnPlay.setVisible(true);
			} 
			else {
				btnPlay.setVisible(false);
			}
		}
	}
		
	void showFilteredMedia(String filter) {
	    filteredMediaList.setPredicate(media -> {
	        if (filter == null || filter.isEmpty()) {
	            return true;
	        }
	        if (lastSelectedRadioButton == radioBtnFilterId) {
	            try {
	                int id = Integer.parseInt(filter);
	                return media.getId() == id;
	            } catch (NumberFormatException e) {
	                return false;
	            }
	        } else if (lastSelectedRadioButton == radioBtnFilterTitle) {
		        String lowerCaseFilter = filter.toLowerCase();
	            return media.getTitle().toLowerCase().contains(lowerCaseFilter);
	        }

	        return true; 
	    });
	}
	  
    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML 
    void btnOrderClicked(ActionEvent event){
    	cart = new Cart();
        tblMedia.setItems(cart.getItemsOrdered());
        JOptionPane.showMessageDialog(null, "Placed your order successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        setTotalCost();
    }
}