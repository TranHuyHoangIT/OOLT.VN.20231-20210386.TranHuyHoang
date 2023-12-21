package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private float cost;

	public Media() {

	}
	
	public Media(String title) {
		super();
		this.title = title;	
	}
	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void printDetail() {
		System.out.printf("%s - %s: %f $\n", this.getTitle(), this.getCategory(), this.getCost());
	}
	
	public boolean equals(Object obj) throws ClassCastException {
		if(obj == null) return false;
		try {
			Media objTmp = (Media) obj;
            if (objTmp.getTitle().equals(this.title) && objTmp.getCost() == this.cost) {
            	return true;
            }
            else return false;
		} catch (ClassCastException e) {
			throw e;
        }
    }
	
	public int compareTo(Media obj) throws NullPointerException {
        try {
            for (int i = 0; i < this.title.length() && i < obj.getTitle().length(); i++) {
                if ((int) this.title.charAt(i) == (int) obj.getTitle().charAt(i)) {
                    continue;
                } else {
                    return ((int) this.title.charAt(i) - (int) obj.getTitle().charAt(i));
                }
            }
            if (!(this.title.length() == obj.getTitle().length())) {
                return (this.title.length() - obj.getTitle().length());
            }
            for (int i = 0; i < this.category.length() && i < obj.getCategory().length(); i++) {
                if ((int) this.category.charAt(i) == (int) obj.getCategory().charAt(i)) {
                    continue;
                } else {
                    return ((int) this.category.charAt(i) - (int) obj.getTitle().charAt(i));
                }
            }
            if (!(this.category.length() == obj.getCategory().length())) {
                return (this.category.length() - obj.getCategory().length());
            }
            return 0;
        } catch (NullPointerException e) {
            throw e;
        }
    }
}