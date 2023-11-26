package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	
	public Book() {

	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public boolean addAuthor(String authorName){
	        if (authors.contains(authorName)) {
	            System.out.println("This author already exists!");
	            return false;
	        }
	        authors.add(authorName);
	        System.out.println("Author " + authorName + " has been added.");
	        return true;
	    }
	
	public boolean removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("This author does not exist");
            return false;
        }
        authors.remove(authorName);
        System.out.println("Author " + authorName + " has been removed.");
        return true;
    }
}