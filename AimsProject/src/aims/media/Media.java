package aims.media;

public abstract class Media {

    public static int nbMedia = 0;

    public int id;

    private String title;

    private String category;

    private float cost;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public String getAllInfo() {
        return "ID: " + id + " | Title: " + title + " | Category: " + category + " | Cost: $" + cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media other = (Media) obj;
            return this.title == other.title;
        }
        return false;
    }
}
