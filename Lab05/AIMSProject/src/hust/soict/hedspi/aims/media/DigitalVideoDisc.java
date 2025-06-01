package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(String title) {
	        super(nbMedia++, title, null, 0, 0, null);
	}
	    
	public DigitalVideoDisc(String title, String category, float cost) {
	        super(nbMedia++, title, category, cost, 0, null);
	}
	    
	public DigitalVideoDisc(String title, String category, float cost, String director) {
	        super(nbMedia++, title, category, cost, 0, director);
	}
	    
	public DigitalVideoDisc(String title, String category, float cost, int length, String director ) {
	        super(nbMedia++, title, category, cost, length, director);
	}
	public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getCost() + 
               " $ - " + getLength() + ": " + getDirector();
    }
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
//    public void play() {
//        System.out.println("Playing DVD: " + this.getTitle());
//        System.out.println("DVD length: " + this.getLength());
//    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
