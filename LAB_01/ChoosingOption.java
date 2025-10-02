package LAB_01;
import javax.swing.JOptionPane;

public class ChoosingOption {

    public static void main(String[] args) {
        
        int choice = JOptionPane.showConfirmDialog(null, "Do you wish to upgrade to first class?");

        JOptionPane.showMessageDialog(null, "You've chosen: " + (choice == JOptionPane.YES_OPTION ? "First Class" : "Economy Class"), "Confirm", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
