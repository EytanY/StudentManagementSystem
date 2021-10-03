package Swing;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class StudentMangementFrame extends JFrame {
    public StudentMangementFrame() {
        this.setVisible(true);
        this.setSize(450, 450);
        this.setResizable(false);
        this.setTitle("Student Mangement System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(229, 230, 204));
        ImageIcon image = new ImageIcon( // load image icon
                "C:\\Users\\etan1\\OneDrive\\מסמכים\\GitHub\\StudentMangement\\StudentManagement\\Photos\\menu.png");
        this.setIconImage(image.getImage()); // set image in window
    }

}
