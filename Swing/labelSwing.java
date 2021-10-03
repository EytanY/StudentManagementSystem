package Swing;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class labelSwing {

    public static void main(String[] args) {
        LocalDate cuurentDate = LocalDate.now();
        // JLabel = A GUI display area for a string of text an image or both
        JLabel label = new JLabel(); // create label object
        label.setText(cuurentDate + "\n"); // set text of label
        ImageIcon image = new ImageIcon(
                "C:\\Users\\etan1\\OneDrive\\מסמכים\\GitHub\\StudentMangement\\StudentManagement\\Photos\\menu.png");

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setIcon(image); // set image to label
        label.setBorder(border);
        // position in label
        label.setHorizontalTextPosition(JLabel.CENTER);// set text Left, Cetner , Right of imageicon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP, Center , Bottom of imageicon
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        // Style Sheet
        // label.setForeground(Color.BLUE); // change the color of the text
        label.setFont(new Font("MV Boli", Font.PLAIN, 30)); // change the font and size of the text in label
        label.setIconTextGap(20); // set the gap between the image and text
        // label.setBackground(Color.BLACK); // change the background of label
        // label.setOpaque(true); // make it

        // Limit of Label
        // label.setBounds(150, 20, 350, 350);
        StudentMangementFrame frame = new StudentMangementFrame();
        // frame.setLayout(null);
        frame.add(label); // add label to frame
        frame.pack(); // open the nessery size

    }

}
