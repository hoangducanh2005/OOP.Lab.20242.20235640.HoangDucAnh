package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.Aims;	
import hust.soict.hedspi.aims.media.Book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfAuthors;
    private JTextField tfCost;

    public AddBookToStoreScreen() {
        super("Book");
        
        setJMenuBar(createMenuBar());
        JPanel center = createCenter();
        tfTitle = addInputField("Title: *", center);
        tfCategory = addInputField("Category:", center);
        tfAuthors = addInputField("Author(s):", center);
        tfCost = addInputField("Cost: *", center);
        center.add(Box.createRigidArea(new Dimension(10, 40)));
        add(center, BorderLayout.CENTER);
        add(createSouth(new ButtonListener()), BorderLayout.SOUTH);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "OK": {
                    if (tfTitle.getText().equals("") || tfCost.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Some required fields (*) are empty!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    float cost = Float.parseFloat(tfCost.getText());

                    Book book = new Book(
                            tfTitle.getText(),
                            tfCategory.getText(),
                            cost
                    );

                    for (String author : tfAuthors.getText().split(",\\s*")) {
                        if (!author.isEmpty()) {
                            book.addAuthor(author);
                        }
                    }

                    Aims.getStore().addMedia(book);
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "New Book added to store!");
                    Aims.closeStoreScreen();
                    Aims.openStoreScreen();
                    break;
                }

                case "Cancel":
                    setVisible(false);
                    Aims.openStoreScreen();
                    break;
            }
        }
    }
}