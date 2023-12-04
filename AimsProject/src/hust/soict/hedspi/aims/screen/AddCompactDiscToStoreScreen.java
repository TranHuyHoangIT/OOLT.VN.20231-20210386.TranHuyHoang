package hust.soict.hedspi.aims.screen;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField directorField;
	private JTextField lengthField;

	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}
	
	JPanel createHeader() {
		JPanel header = super.createHeader();
	    JLabel title = (JLabel) header.getComponent(1);
	    title.setText("ADD CD TO STORE");
	    return header;
	}
	
	JPanel createCenter() {
		Font customFont = new Font("Arial", Font.PLAIN, 30);
		JPanel center = super.createCenter();
		
        JLabel directorLabel = new JLabel("Director:");
        directorLabel.setFont(customFont);
        directorField = new JTextField(15);
        directorField.setFont(customFont);
        
        JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setFont(customFont);
        lengthField = new JTextField(15);
        lengthField.setFont(customFont);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); 
        
        addComponent(center, directorLabel, constraints, 0, 3);
        addComponent(center, directorField, constraints, 1, 3);
        addComponent(center, lengthLabel, constraints, 0, 4);
        addComponent(center, lengthField, constraints, 1, 4);
        
        return center;
	}
	
	JButton createAddButton() {
        JButton addButton = super.createAddButton(); 
        addButton.addActionListener(new AddCompactDiscButtonListener());
        return addButton;
    }
	
    private class AddCompactDiscButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String title = titleField.getText();
            String category = categoryField.getText();
            String cost = costField.getText();
            String director = directorField.getText();
            String length = lengthField.getText();
            if(title.isEmpty() || category.isEmpty() || cost.isEmpty() || director.isEmpty() || length.isEmpty()) {
            	JOptionPane.showMessageDialog(null, "You have not entered enough information. Please check again", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
            	Float costFloat = Float.parseFloat(cost);
            	int lengthInt = Integer.parseInt(length);
            	CompactDisc cd = new CompactDisc(store.getItemsInStore().size(),title, category, costFloat, director, lengthInt);
            	store.addMedia(cd);
            	JOptionPane.showMessageDialog(null, "CD " + cd.getTitle() + " have added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

