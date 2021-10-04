package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Model.Student;
import java.awt.Font;
import java.time.LocalDate;

public class View {
	private JButton buttonSearchStudent = getButtonForMenu("Search Student");
	private JButton buttonAddStudent = getButtonForMenu("Add Student");
	private JButton buttonEnter = getButtonForMenu("Search");
	private JButton buttonMenu = getButtonForMenu("Menu");
	private JButton buttonCurses = getButtonForMenu("Curses");

	private JTextField idTextField = new JTextField();

	public JLabel getJLabelForMenu() {
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

	public JButton getButtonForMenu(String text) {
		JButton button = new JButton();
		button.setText(text);
		button.setFocusable(false);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setFont(new Font("Monospaced", Font.BOLD, 15));
		return button;
	}

	public JPanel getPanelInfo(Student student) {
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 400, 400);
		panel.setLayout(null);
		Font font = new Font("Monospaced", Font.BOLD, 18);

		JLabel infoStundetlabel = new JLabel("Information:");
		infoStundetlabel.setFont(font);
		infoStundetlabel.setBounds(50, 20, 300, 50);
		panel.add(infoStundetlabel);

		JLabel firstNamelabel = new JLabel("First name:" + student.getFirstName());
		JLabel lastNamelabel = new JLabel("Last name:" + student.getLastName());
		JLabel sexlabel = new JLabel("Sex:" + student.getSex());
		JLabel idlabel = new JLabel("ID:" + student.getId());
		JLabel birthDatelabel = new JLabel("Birth date:" + student.getBirthDate());
		JLabel fatherNamelabel = new JLabel("Father's name:" + student.getFatherName());
		JLabel motherNamelabel = new JLabel("mother's name:" + student.getMotherName());
		JLabel emaillabel = new JLabel("Email:" + student.getEmail());
		JLabel avaregelabel = new JLabel("Avarege:" + student.getAverage());
		JLabel[] arrLabel = { firstNamelabel, lastNamelabel, sexlabel, idlabel, birthDatelabel, fatherNamelabel,
				motherNamelabel, emaillabel, avaregelabel };
		for (int index = 0; index < 9; index++) {
			arrLabel[index].setBounds(50, 100 + index * 30, 300, 50);
			arrLabel[index].setFont(font);
			panel.add(arrLabel[index]);
		}

		buttonMenu.setBounds(50, 430, 100, 40);
		buttonCurses.setBounds(200, 430, 100, 40);
		panel.add(buttonMenu);
		panel.add(buttonCurses);
		panel.setBackground(new Color(229, 230, 204));
		panel.setFont(new Font("Monospaced", Font.BOLD, 15));
		return panel;
	}

	public JButton getSearchStudentButton() {
		return buttonSearchStudent;
	}

	public JButton getAddStudentButton() {
		return buttonAddStudent;
	}

	public JButton getEnterButton() {
		return buttonEnter;
	}

	public JButton getMenuButton() {
		return buttonMenu;
	}

	public JButton getCursesButton() {
		return buttonCurses;
	}

	public JTextField getIdTextField() {
		return idTextField;
	}

	public void resetIdTextField() {
		idTextField.setText("");
	}

}
