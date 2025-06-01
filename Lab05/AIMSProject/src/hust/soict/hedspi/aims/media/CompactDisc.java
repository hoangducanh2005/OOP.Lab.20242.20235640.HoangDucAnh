package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc() {
        super();
    }
    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(nbMedia++, title, category, cost, 0, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) {
        super(nbMedia++, title, category, cost, 0, director);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(nbMedia++, title, category, cost, 0, null);
        this.artist = artist;
        
    }
    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track is already in the CD");
        } else {
            tracks.add(track);
            System.out.println("Track added");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track removed");
        } else {
            System.out.println("Track does not exist in the CD");
        }
    }
    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public int getTracksCount() {
        return tracks.size();
    }
    public String toString() {
        return "CD - " + title + " - " + category + " - " + getDirector() + 
               " - " + getArtist() + " - Tracks: " + getTracksCount() + 
               " - Length: " + getLength() + " : " + cost + " $";
    }
//    public void play() {
//        System.out.println("Playing CD: " + this.getTitle());
//        System.out.println("CD artist: " + this.getArtist());
//        System.out.println("CD length: " + this.getLength());
//        for (Track track : tracks) {
//            track.play();
//        }
//    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            java.util.Iterator<Track> iter = tracks.iterator();
            while (iter.hasNext()) {
                Track nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}