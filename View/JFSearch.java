package View;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFSearch extends JFStudentManagement {

    private JTextField idTextField = new JTextField();
    private JButton buttonEnter = getButtonForMenu("Search");

    public JFSearch() {
        this.add(getLabelForSearchStudent());
    }

    public JLabel getLabelForSearchStudent() {
        JLabel label = new JLabel();
        label.setText("Enter Student's Id:");

        ImageIcon image = new ImageIcon(
                "C:\\Users\\etan1\\OneDrive\\מסמכים\\GitHub\\StudentMangement\\StudentManagement\\Photos\\search.png");
        label.setIcon(image);

        idTextField.setText("");
        idTextField.setBounds(100, 320, 120, 20);
        label.add(idTextField);

        buttonEnter.setBounds(250, 320, 100, 20);
        label.add(buttonEnter);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));

        return label;
    }

    public JButton getEnterButton() {
        return buttonEnter;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(String text) {
        idTextField.setText(text);
    }
}
