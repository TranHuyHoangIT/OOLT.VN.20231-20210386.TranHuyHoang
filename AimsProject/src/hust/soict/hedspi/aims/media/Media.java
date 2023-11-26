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

	public boolean equals(Object obj) throws NullPointerException, ClassCastException {
		if (obj == null) {
			throw new NullPointerException("Object is null!");
		} else if (!(obj instanceof Media)) {
			throw new ClassCastException("Object is not Media!");
		}
		Media media = (Media) obj;
		return this.title.equalsIgnoreCase(media.title);
	}
}