package Swing;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel {

    public static void main(String[] args) {
        // Create JLabel
        ImageIcon image = new ImageIcon(
                "C:\\Users\\etan1\\OneDrive\\מסמכים\\GitHub\\StudentMangement\\StudentManagement\\Photos\\thumbup.jpg");
        JLabel label = new JLabel();
        label.setText("Hello");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);

        label.setVerticalAlignment(JLabel.CENTER);
        // Create Jpanel
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250); // limit of panel
        redPanel.add(label);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(500, 0, 250, 250); // limit of panel

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(250, 0, 250, 250); // limit of panel

        // StudentMangementFrame frame = new StudentMangementFrame();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 650);
        frame.setVisible(true);
        frame.add(redPanel); // add panel
        frame.add(bluePanel);
        frame.add(greenPanel);
    }

}
