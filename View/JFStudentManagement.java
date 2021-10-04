package View;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;

public class JFStudentManagement extends JFrame {
    public JFStudentManagement() {
        this.setLocation(400, 70);
        this.setVisible(true);
        this.setSize(450, 550);
        this.setResizable(false);
        this.setTitle("Student Mangement System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(229, 230, 204));
    }

    public JButton getButtonForMenu(String text) {
        JButton button = new JButton();
        button.setText(text);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setFont(new Font("Monospaced", Font.BOLD, 15));
        return button;
    }
}
