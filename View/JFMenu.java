package View;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.time.LocalDate;

public class JFMenu extends JFStudentManagement {
    private JButton buttonSearchStudent = getButtonForMenu("Search Student");
    private JButton buttonAddStudent = getButtonForMenu("Add Student");

    public JFMenu() {
        this.add(getLabelForMenu());
    }

    public JLabel getLabelForMenu() {
        LocalDate cuurentDate = LocalDate.now();
        JLabel label = new JLabel();
        label.setText(cuurentDate + "\n");
        ImageIcon image = new ImageIcon(
                "C:\\Users\\etan1\\OneDrive\\מסמכים\\GitHub\\StudentMangement\\StudentManagement\\Photos\\menu.png");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setIconTextGap(20);
        label.setIcon(image);

        buttonSearchStudent.setBounds(130, 300, 170, 40);
        buttonAddStudent.setBounds(130, 360, 170, 40);
        label.add(this.buttonSearchStudent);
        label.add(this.buttonAddStudent);

        return label;
    }

    public JButton getSearchStudentButton() {
        return buttonSearchStudent;
    }

    public JButton getAddStudentButton() {
        return buttonAddStudent;
    }

    public static void main(String[] args) {
        JFMenu menu = new JFMenu();
    }
}
