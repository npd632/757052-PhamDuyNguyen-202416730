package aims.media;

public class DigitalVideoDisc extends Disc {

    private static int nbDigitalVideoDiscs = 0;

    private int createdTime;

    public void setCreatedTime(int createdTime) {
        this.createdTime = createdTime;
    }

    public int getCreatedTime() {
        return createdTime;
    }

    public String getAllInfo() {
        return "DVD - " + getId() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + "$" + getCost();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

}