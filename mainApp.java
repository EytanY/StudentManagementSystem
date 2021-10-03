import javax.swing.JFrame;
import java.awt.Color;
import View.ViewMenu;

public class mainApp {
    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();

        JFrame frame = new JFrame();
        frame.add(viewMenu.getJLabelForMenu());

        frame.setVisible(true);
        frame.setSize(450, 450);
        frame.setResizable(false);
        frame.setTitle("Student Mangement System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(229, 230, 204));
    }
}
