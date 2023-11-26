package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc ("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc ("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle dvd title: "+ jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
// Incorrect swap method
	public static void swap (Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2= tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc (oldTitle);
	}
	
//	Correct swap method
	public static void swapDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    String tempTitle = dvd1.getTitle();
	    String tempCategory = dvd1.getCategory();
	    String tempDirector = dvd1.getDirector();
	    int tempLength = dvd1.getLength();
	    float tempCost = dvd1.getCost();

	    dvd1.setTitle(dvd2.getTitle());
	    dvd1.setCategory(dvd2.getCategory());
//	    dvd1.setDirector(dvd2.getDirector());
//	    dvd1.setLength(dvd2.getLength());
	    dvd1.setCost(dvd2.getCost());

	    dvd2.setTitle(tempTitle);
	    dvd2.setCategory(tempCategory);
//	    dvd2.setDirector(tempDirector);
//	    dvd2.setLength(tempLength);
	    dvd2.setCost(tempCost);
	}

}