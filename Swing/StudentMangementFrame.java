package Swing;

import java.awt.Color;
import javax.swing.JFrame;

public class StudentMangementFrame extends JFrame {
    public StudentMangementFrame() {
        this.setVisible(true);
        this.setSize(550, 650);
        this.setTitle("Student Mangement System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(229, 230, 204));
    }

    public static void main(String[] args) {
        StudentMangementFrame frame = new StudentMangementFrame();
    }
}
