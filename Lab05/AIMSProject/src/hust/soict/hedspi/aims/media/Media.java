package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media>{

	int id;
	String title;
	String category;
	float cost;
	public static int nbMedia = 1;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public Media() {
		
	}
	
	public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
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
//	public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || !(obj instanceof Media)) return false;
//        Media media = (Media) obj;
//        if (this.title == null) {
//            return media.title == null;
//        }
//        return this.title.equalsIgnoreCase(media.title);
//    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return this.title != null && this.title.equalsIgnoreCase(other.title)
               && this.cost == other.cost;
    }
	@Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Compared media is null");
        if (!(other instanceof Media)) {
            throw new ClassCastException("Cannot compare Media with non-Media object.");
        }
        int titleCompare = this.title.compareToIgnoreCase(other.title);
        if (titleCompare != 0) return titleCompare;
        return Float.compare(this.cost, other.cost);
    }
	@Override
    public String toString() {
        return String.format("Media - Title: %s | Category: %s | Cost: %.2f", title, category, cost);
    }
}
