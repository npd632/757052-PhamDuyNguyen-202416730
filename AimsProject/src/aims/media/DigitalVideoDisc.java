package aims.media;

public class DigitalVideoDisc extends Media {

    private static int nbDigitalVideoDiscs = 0;

    private String director;

    private int length;

    private int createdTime;

    public void setCreatedTime(int createdTime) {
        this.createdTime = createdTime;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public int getCreatedTime() {
        return createdTime;
    }

    public String getAllInfo() {
        return "DVD - " + getId() + " - " + getCategory() + " - " + director + " - " + length + ": " + "$" + getCost();
    }

    public DigitalVideoDisc(String title) {
        super();
        setTitle(title);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.director = director;
        setTitle(title);
        setCategory(category);
        setCost(cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

}