package Swing;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class jframe {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // Create Frame\Stage
        frame.setVisible(true); // make frame visible
        frame.setSize(550, 650); // size of frame
        frame.setTitle("Student Mangement System"); // title for window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // after exit the program stop running
        frame.setResizable(false); // not allowed to change the size of the window

        ImageIcon image = new ImageIcon( // load image icon
                "C:\\Users\\etan1\\OneDrive\\מסמכים\\GitHub\\StudentMangement\\StudentManagement\\Photos\\logo.jpg");
        frame.setIconImage(image.getImage()); // set image in window

        frame.getContentPane().setBackground(Color.GRAY); // change the color of background
        // Create our color
        Color newColor = new Color(229, 255, 204);
        frame.getContentPane().setBackground(newColor);

    }
}
