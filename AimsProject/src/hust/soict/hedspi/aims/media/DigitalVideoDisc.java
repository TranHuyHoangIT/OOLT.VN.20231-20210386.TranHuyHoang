package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	 public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	     super(title, category, director, length ,cost);
	}

	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}
	
	public String toString() {
		return this.getId() + ".DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$\n";
	}

	public boolean isMatch(String title) {
		return this.getTitle().equals(title);
	}
	
	// Overloading
	public boolean isMatch(int id) {
		return this.getId() == id;
	}
	
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: "+ this.getLength());
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
}
