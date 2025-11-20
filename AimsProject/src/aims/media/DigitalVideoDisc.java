package aims.media;

public class DigitalVideoDisc extends Disc implements Play {

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

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength()); 
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