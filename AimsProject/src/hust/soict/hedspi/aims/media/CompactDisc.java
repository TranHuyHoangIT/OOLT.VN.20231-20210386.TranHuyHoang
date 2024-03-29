package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable  {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    public String getArtist() {
		return artist;
	}
    
	public void setArtist(String artist) {
		this.artist = artist;
	}
    
    public CompactDisc() {

	}
	
	 public CompactDisc(String title) {
	     super(title);
	}
	 
	 public CompactDisc(String title, String category, String director, int length, float cost) {
	     super(title, category, director, length, cost);
	}
	 
	 public CompactDisc(int id, String title, String category, float cost, String director) {
	     super(id, title, category, cost, director);
	}
	 
	 public CompactDisc(int id, String title, String category, float cost, String director, int length) {
	     super(id, title, category, cost, director, length);
	}

	public boolean addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.printf("The track has been added\n");
			return true;
		} else {
			System.out.println("The track is already in list of this tracks!\n");
			return false;
		}
	}

	public boolean removetrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.printf("The track has been removed\n");
			return true;
		} else {
			System.out.println("The track is not already in list of tracks!\n");
			return false;
		}
	}

    public int getLength() {
        int sumLength = 0;
        for (Track track : tracks) {
            sumLength += track.getLength();
        }
        return sumLength;
    }

    public void play() throws PlayerException {
    	if(this.getLength() > 0) {  		
    		Iterator<Track> iterator = tracks.iterator();
    		Track nexTrack;
    		while(iterator.hasNext()) {
    			nexTrack = (Track) iterator.next();
    			try {
					nexTrack.play();
				} catch (PlayerException e) {
					throw e;
				}
    		}
    	}
    	else {
    		throw new PlayerException("ERROR: CD length is non-positive!");
    	}
    }
  
    public ArrayList<Track> getTrack() {
    	return tracks;
    }
}