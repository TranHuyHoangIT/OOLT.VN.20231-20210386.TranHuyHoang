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
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField authorField;

	public AddBookToStoreScreen(Store store) {
		super(store);
	}
	
	JPanel createHeader() {
		JPanel header = super.createHeader();
	    JLabel title = (JLabel) header.getComponent(1);
	    title.setText("ADD BOOK TO STORE");
	    return header;
	}
	
	JPanel createCenter() {
		Font customFont = new Font("Arial", Font.PLAIN, 30);
		JPanel center = super.createCenter();
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setFont(customFont);
        authorField = new JTextField(15);
        authorField.setFont(customFont);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); 
        
        addComponent(center, authorLabel, constraints, 0, 3);
        addComponent(center, authorField, constraints, 1, 3);
        
        return center;
	}
	
	JButton createAddButton() {
        JButton addButton = super.createAddButton(); 
        addButton.addActionListener(new AddBookButtonListener());
        return addButton;
    }
	
    private class AddBookButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String title = titleField.getText();
            String category = categoryField.getText();
            String cost = costField.getText();
            String author = authorField.getText();
   
            if(title.isEmpty() || category.isEmpty() || cost.isEmpty() || author.isEmpty()) {
            	JOptionPane.showMessageDialog(null, "You have not entered enough information. Please check again", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
            	Float costFloat = Float.parseFloat(cost);
            	Book book = new Book(store.getItemsInStore().size() + 1, title, category, costFloat);
            	book.addAuthor(author);
                store.addMedia(book);
            	JOptionPane.showMessageDialog(null, "DVD " + book.getTitle() + " have added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
