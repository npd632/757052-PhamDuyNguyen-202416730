package aims.media;

public class DigitalVideoDisc extends Disc implements Play {

    @Override
    public String getAllInfo() {
        return "DVD - ID: " + this.id + " - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + "mins : " + "$" + getCost();
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength()); 
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
        nbMedia += 1;
        this.id = nbMedia;
    }

}