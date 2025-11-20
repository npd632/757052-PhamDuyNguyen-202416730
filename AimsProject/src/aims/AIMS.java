package aims;
import java.util.*;
import aims.cart.Cart;
import aims.media.DigitalVideoDisc;

public class AIMS {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1  = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2  = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3  = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        DigitalVideoDisc dvd4  = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f);
        DigitalVideoDisc dvd5  = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 22.99f);
        DigitalVideoDisc dvd6  = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 25.99f);
        DigitalVideoDisc dvd7  = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 27.99f);
        DigitalVideoDisc dvd8  = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 20.99f);
        DigitalVideoDisc dvd9  = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 23.99f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 21.99f);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 19.99f);
        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowskis", 136, 18.99f);
        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 22.99f);
        DigitalVideoDisc dvd14 = new DigitalVideoDisc("Jurassic Park", "Science Fiction", "Steven Spielberg", 127, 24.99f);
        DigitalVideoDisc dvd15 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 19.99f);
        DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 26.99f);
        DigitalVideoDisc dvd17 = new DigitalVideoDisc("Harry Potter and the Sorcerer's Stone", "Fantasy", "Chris Columbus", 152, 21.99f);
        DigitalVideoDisc dvd18 = new DigitalVideoDisc("The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 178, 29.99f);
        DigitalVideoDisc dvd19 = new DigitalVideoDisc("The Dark Knight Rises", "Action", "Christopher Nolan", 165, 24.99f);
        DigitalVideoDisc dvd20 = new DigitalVideoDisc("Inglourious Basterds", "War", "Quentin Tarantino", 153, 22.99f);
        DigitalVideoDisc dvd21 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 17.99f);
        DigitalVideoDisc dvd22 = new DigitalVideoDisc("The Prestige", "Drama", "Christopher Nolan", 130, 21.99f);
        DigitalVideoDisc dvd23 = new DigitalVideoDisc("Memento", "Thriller", "Christopher Nolan", 113, 19.99f);
        DigitalVideoDisc dvd24 = new DigitalVideoDisc("Dunkirk", "War", "Christopher Nolan", 106, 23.99f);
        DigitalVideoDisc dvd25 = new DigitalVideoDisc("The Departed", "Crime", "Martin Scorsese", 151, 22.99f);
        DigitalVideoDisc dvd26 = new DigitalVideoDisc("The Social Network", "Drama", "David Fincher", 120, 18.99f);
        DigitalVideoDisc dvd27 = new DigitalVideoDisc("The Silence of the Lambs", "Thriller", "Jonathan Demme", 118, 20.99f);
        DigitalVideoDisc dvd28 = new DigitalVideoDisc("Saving Private Ryan", "War", "Steven Spielberg", 169, 24.99f);
        DigitalVideoDisc dvd29 = new DigitalVideoDisc("Braveheart", "War", "Mel Gibson", 178, 21.99f);
        DigitalVideoDisc dvd30 = new DigitalVideoDisc("The Green Mile", "Drama", "Frank Darabont", 189, 19.99f);
        DigitalVideoDisc dvd31 = new DigitalVideoDisc("The Pianist", "Drama", "Roman Polanski", 150, 18.99f);
        DigitalVideoDisc dvd32 = new DigitalVideoDisc("Goodfellas", "Crime", "Martin Scorsese", 146, 22.99f);
        DigitalVideoDisc dvd33 = new DigitalVideoDisc("Schindler's List", "Drama", "Steven Spielberg", 195, 25.99f);
        DigitalVideoDisc dvd34 = new DigitalVideoDisc("Fight Club", "Drama", "David Fincher", 139, 20.99f);
        DigitalVideoDisc dvd35 = new DigitalVideoDisc("The Wolf of Wall Street", "Comedy", "Martin Scorsese", 180, 23.99f);
        DigitalVideoDisc dvd36 = new DigitalVideoDisc("La La Land", "Romance", "Damien Chazelle", 128, 19.99f);
        DigitalVideoDisc dvd37 = new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 105, 17.99f);
        DigitalVideoDisc dvd38 = new DigitalVideoDisc("Inside Out", "Animation", "Pete Docter", 95, 16.99f);
        DigitalVideoDisc dvd39 = new DigitalVideoDisc("Up", "Animation", "Pete Docter", 96, 18.99f);
        DigitalVideoDisc dvd40 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 15.99f);

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String username = "";

        DigitalVideoDisc[] store = {
            dvd1, dvd2, dvd3, dvd4, dvd5,
            dvd6, dvd7, dvd8, dvd9, dvd10,
            dvd11, dvd12, dvd13, dvd14, dvd15,
            dvd16, dvd17, dvd18, dvd19, dvd20,
            dvd21, dvd22, dvd23, dvd24, dvd25,
            dvd26, dvd27, dvd28, dvd29, dvd30,
            dvd31, dvd32, dvd33, dvd34, dvd35,
            dvd36, dvd37, dvd38, dvd39, dvd40
        };

    }
}