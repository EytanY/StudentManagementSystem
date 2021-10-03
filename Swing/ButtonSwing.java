package Swing;

import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class ButtonSwing {
    public static JButton button;
    public static JButton button2;
    public static JLabel label;
    public static JLabel label2;
    public static StudentMangementFrame frame;

    public static JLabel getMenuJLabel() {
        LocalDate cuurentDate = LocalDate.now();
        JLabel label = new JLabel();
        label.setText(cuurentDate + "\n");
        ImageIcon image = new ImageIcon(
                "C:\\Users\\etan1\\OneDrive\\מסמכים\\GitHub\\StudentMangement\\StudentManagement\\Photos\\menu.png");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setIconTextGap(20);
        label.setIcon(image);
        label.setBorder(border);
        return label;

    }

    public static void main(String[] args) {
        label2 = new JLabel();
        label2.setText("Press on Search Student");
        label2.setVisible(false);
        // JButton = Button
        button = new JButton(); // create button
        button.setBounds(130, 300, 170, 40); // location on screen + size
        button.setText("Search Student"); // text on button
        button.setFocusable(false); // remove the mark on text
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setFont(new Font("Monospaced", Font.BOLD, 15));
        button.addActionListener(e -> { // action when press on it
            System.out.println("Press on Search Student");

        });

        button2 = new JButton();
        button2.setBounds(130, 360, 170, 40);
        button2.setText("Add Student");
        button2.setFocusable(false);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setFont(new Font("Monospaced", Font.BOLD, 15));
        button2.addActionListener(e -> {
            System.out.println("Press on Add Student");
        });

        label = getMenuJLabel();
        label.add(button);
        label.add(button2);
        frame = new StudentMangementFrame();
        frame.add(label, BorderLayout.CENTER);
    }

}
