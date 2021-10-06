package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class JFStudentManagement extends JFrame {
    public JFStudentManagement(JLabel label) {
        newFrame();
        this.add(label);
    }

    public JFStudentManagement(JPanel panel) {
        newFrame();
        this.add(panel, BorderLayout.CENTER);
    }

    public JFStudentManagement(JScrollPane sp) {
        newFrame();
        this.add(sp);
    }

    public void newFrame() {
        this.setVisible(true);
        this.setSize(450, 550);
        this.setResizable(false);
        this.setTitle("Student Mangement System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400, 70);
        this.getContentPane().setBackground(new Color(229, 230, 204));
    }

}
