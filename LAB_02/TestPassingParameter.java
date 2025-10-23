public class TestPassingParameter {

    public static void main(String[] args) {

        DigitalVideoDisc d1 = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc d2 = new DigitalVideoDisc("Cinderella");

        swap(d1, d2);
        System.out.println("jg title: " + d1.getTitle());
        System.out.println("cn title: " + d2.getTitle());

        changeTitle(d1, d2.getTitle());
        System.out.println("jg title: " + d1.getTitle());
        System.out.println("cn title: " + d2.getTitle());

    }

    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        DigitalVideoDisc temp = d1;
        d1 = d2;
        d2 = temp;
    }
    public static void changeTitle(DigitalVideoDisc d, String title) {
        String oldTitle = d.getTitle();
        d.setTitle(title);
        d = new DigitalVideoDisc(oldTitle);
    }
}
