package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable  {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public Track() {
		
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
		else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
	
	public boolean equals(Object obj) {
        if (!(obj instanceof Track))
            return false;
        return this.title.equalsIgnoreCase(((Track) obj).title) && this.length == ((Track) obj).length;
    }
}
