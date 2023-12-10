package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class StoreManagerScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		
		menu.add(new JMenuItem("View store"));
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBookButton = new JMenuItem("Add Book");
		smUpdateStore.add(addBookButton);
		addBookButton.addActionListener(new AddBookListener());
		
		JMenuItem addCDButton = new JMenuItem("Add CD");
		smUpdateStore.add(addCDButton);
		addCDButton.addActionListener(new AddCDListener());
		
		JMenuItem addDVDButton = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVDButton);
		addDVDButton.addActionListener(new AddDVDListener());
		
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
			
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        
	    for (int i = 0; i < Math.min(50, mediaInStore.size()); i++) {
	    	MediaStore cell = new MediaStore(mediaInStore.get(i));
	    	center.add(cell);
	    }
	    
        return center;
    }
	
    private class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	new AddBookToStoreScreen(store);
        	dispose();
        }
    }
	
    private class AddCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	new AddCompactDiscToStoreScreen(store);
        	dispose();
        }
    }
	
    private class AddDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	new AddDigitalVideoDiscToStoreScreen(store);
        	dispose();
        }
    }
    
	public static void main(String[] args) {
		Store store = new Store();
		
		Media media1 = new DigitalVideoDisc(1, "Harry Potter and Chamber of Secret", "Harry Potter", 3.0f, "Tran Huy Hoang", 120);
		Media media2 = new CompactDisc(2, "CD1", "CompactDisc", 2.5f, "Tran Huy Hoang", 180);
		CompactDisc tmp = (CompactDisc)media2;
		tmp.addTrack(new Track("Track1", 40));
		tmp.addTrack(new Track("Track2", 50));
		tmp.addTrack(new Track("Track3", 60));
		tmp.addTrack(new Track("Track4", 30));
		Media media3 = new DigitalVideoDisc(3, "Harry Potter and OOP", "Harry Potter", 3.0f, "Tran Huy Hoang", 130);
		Media media4 = new DigitalVideoDisc(4, "Harry Potter and DB", "Harry Potter", 3.0f, "Tran Huy Hoang", 140);
		Media media5 = new DigitalVideoDisc(5, "Harry Potter and AI", "Harry Potter", 3.0f, "Tran Huy Hoang", 150);
		Media media6 = new DigitalVideoDisc(6, "Harry Potter and DSA", "Harry Potter", 3.0f, "Tran Huy Hoang", 160);
		Media media7 = new Book(7, "Doraemon", "Manga", 1.5f);
		Media media8 = new Book(8, "Giai tich 3", "Lecture", 2.7f);
		Media media9 = new DigitalVideoDisc(9, "Harry Potter and OS", "Harry Potter", 3.0f, "Tran Huy Hoang", 100);
		
		store.addMedia(media1);
		store.addMedia(media2);
		store.addMedia(media3);
		store.addMedia(media4);
		store.addMedia(media5);
		store.addMedia(media6);
		store.addMedia(media7);
		store.addMedia(media8);
		store.addMedia(media9);

		StoreManagerScreen sMS = new StoreManagerScreen(store);

	}
}



