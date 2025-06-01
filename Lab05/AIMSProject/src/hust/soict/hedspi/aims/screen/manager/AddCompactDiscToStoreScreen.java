package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.Aims;	
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfArtist;
    private JTextField tfDirector;
    private JTextField tfCost;
    private JTextField tfNumberTracks;
    private int numberTracks;

    public AddCompactDiscToStoreScreen() {
        super("CD");
        setJMenuBar(createMenuBar());
        JPanel center = createCenter();
        tfTitle = addInputField("Title: *", center);
        tfCategory = addInputField("Category:", center);
        tfArtist = addInputField("Artist", center);
        tfDirector = addInputField("Director:", center);
        tfCost = addInputField("Cost: *", center);
        tfNumberTracks = addInputField("Tracks: *", center);
        center.add(Box.createRigidArea(new Dimension(10, 20)));
        add(center, BorderLayout.CENTER);
        add(createSouth(new ButtonListener()), BorderLayout.SOUTH);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "OK": {
                    if (tfTitle.getText().equals("") || tfCost.getText().equals("")
                            || tfNumberTracks.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Some required fields are empty!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    float cost = Float.parseFloat(tfCost.getText());
                    numberTracks = Integer.parseInt(tfNumberTracks.getText());

                    CompactDisc cd = new CompactDisc(tfTitle.getText(),tfCategory.getText(),tfArtist.getText(),cost);
                    new AddTracksToCompactDiscScreen(cd);  // Start collecting track info
                    break;
                }

                case "Cancel":
                    setVisible(false);
                    Aims.openStoreScreen();
                    break;
            }
        }
    }

    private class AddTracksToCompactDiscScreen extends AddItemToStoreScreen {
        private CompactDisc cd;
        private JLabel lblTrackNo;
        private JTextField tfTitle;
        private JTextField tfLength;
        private int screenIndex;

        public AddTracksToCompactDiscScreen(CompactDisc cd) {
            super("Track");
            this.cd = cd;
            this.screenIndex = 1;
            JPanel center = createCenter();
            lblTrackNo = new JLabel("Track no. " + screenIndex);
            lblTrackNo.setAlignmentX(CENTER_ALIGNMENT);
            center.add(lblTrackNo);
            center.add(Box.createRigidArea(new Dimension(10, 20)));
            tfTitle = addInputField("Title: *", center);
            tfLength = addInputField("Length:", center);
            center.add(Box.createRigidArea(new Dimension(10, 120)));
            add(center, BorderLayout.CENTER);
            add(createSouth(new ButtonListener()), BorderLayout.SOUTH);
            setVisible(true);
        }

        private void reset() {
            tfTitle.setText("");
            tfLength.setText("");
            screenIndex++;
            lblTrackNo.setText("Track no. " + screenIndex);
            setVisible(true);
        }

        private class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "OK": {
                        if (tfTitle.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Required fields (*) are empty!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String title = tfTitle.getText();
                        int length = tfLength.getText().equals("") ? 0 : Integer.parseInt(tfLength.getText());

                        Track track = new Track(title, length);
                        cd.addTrack(track);
                        setVisible(false);

                        if (screenIndex == numberTracks) {
                            Aims.getStore().addMedia(cd);
                            AddCompactDiscToStoreScreen.this.setVisible(false);
                            JOptionPane.showMessageDialog(null, "New CD added to store!");
                            Aims.closeStoreScreen();
                            Aims.openStoreScreen();
                        } else {
                            reset();  // Ask for next track
                        }
                        break;
                    }

                    case "Cancel":
                        setVisible(false);
                        break;
                }
            }
        }
    }
}
