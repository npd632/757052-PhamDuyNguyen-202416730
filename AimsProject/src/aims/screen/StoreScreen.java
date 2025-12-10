package aims.screen;
import javax.swing.*;
import aims.store.Store;
import aims.cart.Cart;
import aims.media.Media;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Track;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    
    private Store Store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(e -> showCart());

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(0, 3, 10, 10));

        ArrayList<Media> mediaInStore = Store.getItemsInStore();
        for (Media m : mediaInStore) {
            MediaStore cell = new MediaStore(m, cart);
            grid.add(cell);
        }

        int cellHeight = 180;
        int numRows = (int) Math.ceil((double) mediaInStore.size() / 3);
        int preferredHeight = numRows * cellHeight + (numRows - 1) * 10;
        grid.setPreferredSize(new Dimension(900, preferredHeight));

        JScrollPane scroll = new JScrollPane(grid);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        JPanel center = new JPanel(new BorderLayout());
        center.add(scroll, BorderLayout.CENTER);
        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.Store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    private void showCart() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        if (cart.getQtyOrdered() == 0) {
            textArea.setText("Your cart is empty.");
        } else {
            StringBuilder cartContent = new StringBuilder();
            for (int i = 0; i < cart.getQtyOrdered(); i++) {
                cartContent.append((i + 1)).append(". ").append(cart.getItemsOrdered()[i].getTitle())
                          .append(" - $").append(cart.getItemsOrdered()[i].getCost()).append("\n");
            }
            cartContent.append("\nTotal Cost: $").append(String.format("%.2f", cart.totalCost()));
            textArea.setText(cartContent.toString());
        }
        
        JScrollPane scroll = new JScrollPane(textArea);
        panel.add(scroll, BorderLayout.CENTER);
        
        JOptionPane.showMessageDialog(this, panel, "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1  = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2  = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3  = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        CompactDisc cd1 = new CompactDisc("Hybrid Theory", "Rock", "Linkin Park", 15.99f, "Chester Bennington");
        cd1.addTrack(new Track("Papercut", 185));
        cd1.addTrack(new Track("One Step Closer", 155));
        cd1.addTrack(new Track("With You", 200));
        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", "AC/DC", 14.99f, "Brian Johnson");
        cd2.addTrack(new Track("Hells Bells", 312));
        cd2.addTrack(new Track("Shoot to Thrill", 315));
        CompactDisc cd3 = new CompactDisc("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 16.99f, "David Gilmour");
        cd3.addTrack(new Track("Speak to Me", 90));
        cd3.addTrack(new Track("Breathe", 163));

        Book book1 = new Book("The Great Gatsby", "Fiction", 10.99f);
        book1.addAuthor("F. Scott Fitzgerald");
        book1.addAuthor("Other Authors");
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        book2.addAuthor("George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Fiction", 12.99f);
        book3.addAuthor("Harper Lee");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        new StoreScreen(store, cart);
    }
}
