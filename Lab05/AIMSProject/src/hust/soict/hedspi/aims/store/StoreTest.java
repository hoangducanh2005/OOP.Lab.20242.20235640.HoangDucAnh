package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Avengers: Endgame");
        
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        store.removeMedia(dvd1);
	}

}
