package aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void getAllInfo() {
        String info = "Book - " + getId() + " - " + getCategory() + " - Authors: ";
        for (String author : authors) {
            info += author + ", ";
        }
        info = info.substring(0, info.length() - 2); // Remove last comma and space
        info += ": $" + getCost();
        System.out.println(info);
    }

    public Book(int id, String title, String category, float cost) {
        super();
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found!");
        }
    }
}
