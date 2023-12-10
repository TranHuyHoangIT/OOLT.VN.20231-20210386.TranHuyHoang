package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItemToStoreScreen extends JFrame{

	private static final long serialVersionUID = 1L;
    protected Store store;
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;

    public AddItemToStoreScreen(Store store) {
    	this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);

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
        
        JMenuItem viewStoreButton = new JMenuItem("View store");
        menu.add(viewStoreButton);
        viewStoreButton.addActionListener(new ViewStoreListener());

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
        JLabel title = new JLabel();
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
    	Font customFont = new Font("Arial", Font.PLAIN, 30);
    	
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); 

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(customFont);
        titleField = new JTextField(15);
        titleField.setFont(customFont);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(customFont);
        categoryField = new JTextField(15);
        categoryField.setFont(customFont);

        JLabel costLabel = new JLabel("Cost:");
        costLabel.setFont(customFont);
        costField = new JTextField(15);
        costField.setFont(customFont);

        addComponent(center, titleLabel, constraints, 0, 0);
        addComponent(center, titleField, constraints, 1, 0);

        addComponent(center, categoryLabel, constraints, 0, 1);
        addComponent(center, categoryField, constraints, 1, 1);

        addComponent(center, costLabel, constraints, 0, 2);
        addComponent(center, costField, constraints, 1, 2);
        
        return center;
    }
    
    JPanel createSouth() {
        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        south.add(createAddButton());
        return south;
    }
    
    JButton createAddButton() {
        Font customFont = new Font("Arial", Font.PLAIN, 30);
        JButton addButton = new JButton("Add");
        addButton.setFont(customFont);
        return addButton;
    }

    protected void addComponent(JPanel panel, JComponent component, GridBagConstraints constraints, int gridx, int gridy) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, constraints);
    }
    
    private class ViewStoreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	new StoreManagerScreen(store);
        	dispose();
        }
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
}
