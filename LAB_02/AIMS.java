public class AIMS {
    public static void main(String[] args) {
        // Create new cart
        Cart anOrder = new Cart();

        // Create new DVDs and add to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f);

        anOrder.removeDigitalVideoDisc(dvd1);

        anOrder.removeDigitalVideoDisc(dvd4);

        // Calculate total cost
        System.out.println("Total cost is: " + anOrder.totalCost());
    }
}