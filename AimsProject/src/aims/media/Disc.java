package aims.media;

public class Disc extends Media {
    
    private int length;
    
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.director = director;
        this.length = length;
    }
}
