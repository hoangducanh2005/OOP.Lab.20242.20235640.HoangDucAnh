package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StoreManagerScreen extends JFrame {
		private Store store;
		JPanel createNorth() {
	        JPanel north = new JPanel();
	        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	        north.add(createMenuBar());
	        north.add(createHeader());
	        return north;
	    }
		
		JMenuBar createMenuBar() {
	        JMenu menu = new JMenu("Options");

	        JMenu smUpdateStore = new JMenu("Update Store");
	        JMenuItem addBook = new JMenuItem("Add Book");
	        JMenuItem addCD = new JMenuItem("Add CD");
	        JMenuItem addDVD = new JMenuItem("Add DVD");
	        addBook.addActionListener(e -> {
	        	this.dispose();
	        	new AddBookToStoreScreen();
	        });
	        addCD.addActionListener(e -> {
	        	this.dispose();
	            new AddCompactDiscToStoreScreen();
	        });
	        addDVD.addActionListener(e -> {
	        	this.dispose();
	            new AddDigitalVideoDiscToStoreScreen();
	        });
	        smUpdateStore.add(addBook);
	        smUpdateStore.add(addCD);
	        smUpdateStore.add(addDVD);

	        menu.add(smUpdateStore);

	        JMenuItem viewStore = new JMenuItem("View Store");
	        menu.add(viewStore);
	        viewStore.addActionListener(e -> {
	            JOptionPane.showMessageDialog(null, "You are viewing the store!");
	            store.getItemsInStore();
	        });

	        JMenuBar menuBar = new JMenuBar();
	        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	        menuBar.add(menu);

	        menuBar.add(Box.createHorizontalGlue());
	        menuBar.add(Box.createHorizontalStrut(250));

//	        JLabel searchLabel = new JLabel("Search by Title: ");
//	        JTextField searchField = new JTextField(20);
//	        searchField.setMaximumSize(new Dimension(200, 30));
//	        searchField.addActionListener(e -> {
//	            String title = searchField.getText();
//	            title = title.toLowerCase();
//	            List<Media> result = store.searchByTitleLowerCase(title);
//	            if (result == null) {
//	                JOptionPane.showMessageDialog(null, "Media not found!", "Error",
//	                        JOptionPane.ERROR_MESSAGE);
//	            } else {
//	                String message = "Media found: \n";
//	                for (Media media : result) {
//	                    message += media.toString() + "\n";
//	                }
//	                JOptionPane.showMessageDialog(null, message);
//	            }
//	        });
//
//	        menuBar.add(searchLabel);
//	        menuBar.add(searchField);

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
	        center.setLayout(new GridLayout(3, 3, 2,2));

	        ArrayList<Media> mediaInStore = store.getItemsInStore();
	        for (int i = 0; i < mediaInStore.size(); i++) {
	            MediaStore cell = new MediaStore(mediaInStore.get(i));
	            center.add(cell);
	        }

	        return center;
	    }
		public StoreManagerScreen(Store store) {
	        this.store = store;

	        Container cp = getContentPane();
	        cp.setLayout(new BorderLayout());
	        cp.add(createNorth(), BorderLayout.NORTH);
	        cp.add(createCenter(), BorderLayout.CENTER);
	        setVisible(true);
	        setTitle("Store");
	        setSize(1024, 768);
	        setLocationRelativeTo(null);
	    }
	}

