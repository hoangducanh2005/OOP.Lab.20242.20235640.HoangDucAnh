package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.Aims;

import java.awt.*;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JFrame {
    public AddItemToStoreScreen(String itemType) {
        super("Add new " + itemType);
        Container cp = getContentPane();
        setSize(1024, 768);
        setLocationRelativeTo(null);
        //setBounds(450, 150, 300, 400);
        setLayout(new BorderLayout());
        
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        JLabel prompt = new JLabel("Please enter new " + itemType + "\'s information");
        prompt.setAlignmentX(CENTER_ALIGNMENT);
        north.add(Box.createRigidArea(new Dimension(10, 10)));
        north.add(prompt);
        north.add(Box.createRigidArea(new Dimension(10, 10)));
        add(north, BorderLayout.NORTH);
    }
    	
    public JTextField addInputField(String fieldName, JPanel panel) {
        JPanel p = new JPanel(new FlowLayout());
        JLabel label = new JLabel(fieldName);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        label.setPreferredSize(new Dimension(300, 150));
        p.add(label);
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(400,  30));
        p.add(textField);
        panel.add(p);
        return textField;
    }

    public JPanel createCenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    public JPanel createSouth(ActionListener listener) {
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));
        JPanel innerPanel = new JPanel(new FlowLayout());
        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("Arial", Font.PLAIN, 20)); 
        btnOk.setPreferredSize(new Dimension(200, 30));  
        btnOk.addActionListener(listener);
        innerPanel.add(btnOk);
        this.getRootPane().setDefaultButton(btnOk);
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        btnCancel.setPreferredSize(new Dimension(200, 30));  
        btnCancel.addActionListener(listener);
        innerPanel.add(btnCancel);
        outerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        outerPanel.add(innerPanel);
        outerPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        return outerPanel;
    }
    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");

        JMenu updateStoreMenu = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            this.setVisible(false);
            new AddBookToStoreScreen();
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            this.setVisible(false);
            new AddCompactDiscToStoreScreen(); // you must create this class
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            this.setVisible(false);
            new AddDigitalVideoDiscToStoreScreen(); // you must create this class
        });

        updateStoreMenu.add(addBook);
        updateStoreMenu.add(addCD);
        updateStoreMenu.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            this.setVisible(false);
            Aims.openStoreScreen();
        });

        optionsMenu.add(updateStoreMenu);
        optionsMenu.add(viewStore);
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(optionsMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(Box.createHorizontalStrut(250));
        

        return menuBar;
    }

}