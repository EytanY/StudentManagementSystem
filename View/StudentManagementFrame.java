package View;

import javax.swing.JFrame;
import java.awt.Color;

public class StudentManagementFrame extends JFrame {
    public StudentManagementFrame() {
        this.setVisible(true);
        this.setSize(450, 450);
        this.setResizable(false);
        this.setTitle("Student Mangement System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(229, 230, 204));
    }
}
