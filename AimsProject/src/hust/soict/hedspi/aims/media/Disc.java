package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	
	public Disc() {

	}
	
	 public Disc(String title) {
	     super(title);
	}
	 
	 public Disc(String title, String category, String director, int length, float cost) {
	     super(title, category, cost);
	     this.director = director;
	     this.length = length;
	}

	 public Disc(int id, String title, String category, float cost, String director, int length) {
	     super(id, title, category, cost);
	     this.length = length;
	     this.director = director;
	}
}
