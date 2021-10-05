package View;

import java.awt.*;
import javax.swing.*;
import Model.Course;
import Model.Student;
import java.time.LocalDate;
import java.util.ArrayList;

public class View {
	private JButton buttonSearchStudent = getButtonForMenu("Search Student");
	private JButton buttonAddStudent = getButtonForMenu("Add Student");
	private JButton buttonEnter = getButtonForMenu("Search");
	private JButton buttonMenu = getButtonForMenu("Menu");
	private JButton buttonCurses = getButtonForMenu("Curses");
	private JButton buttonAddCurses = getButtonForMenu("Add curse");
	private JButton buttonRemoveCurses = getButtonForMenu("Remove curse");
	private JButton buttonRemoveCursesEnter = getButtonForMenu("Remove curse");
	private Color backgroundColoer = new Color(229, 230, 204);
	private Font font = new Font("Monospaced", Font.BOLD, 18);
	private JTextField idTextField = new JTextField();
	private JTextField firstNameTextField = new JTextField();

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

	public JScrollPane getPanelOfCurses(Student student) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(25, 40));
		panel.setBackground(backgroundColoer);

		panel.add(buttonMenu);
		panel.add(buttonAddCurses);
		panel.add(buttonRemoveCurses);

		JLabel courseLabel = new JLabel(student + "");
		courseLabel.setFont(font);
		panel.add(courseLabel);

		ArrayList<Course> curses = student.getCourses();
		for (Course c : curses) {
			JLabel label = new JLabel("[" + (curses.indexOf(c) + 1) + "] - " + c + "");
			label.setFont(font);
			panel.add(label);
		}
		JScrollPane sp = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBackground(backgroundColoer);
		return sp;
	}

	public JLabel getLabelRemoveCourse() {

		firstNameTextField.setBounds(20, 50, 100, 40);
		buttonRemoveCursesEnter.setBounds(20, 120, 150, 40);

		JLabel removeLabel = new JLabel("Enter course's name:");
		removeLabel.setLayout(null);
		removeLabel.setFont(font);
		removeLabel.setHorizontalAlignment(JLabel.CENTER);
		removeLabel.setVerticalAlignment(JLabel.TOP);
		removeLabel.add(buttonRemoveCursesEnter);
		removeLabel.add(firstNameTextField);
		return removeLabel;
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
		panel.setBackground(backgroundColoer);
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

	public JButton getAddCursesButton() {
		return buttonAddCurses;
	}

	public JButton getRemoveButton() {
		return buttonRemoveCurses;
	}

	public JButton getRemoveEnterButton() {
		return buttonRemoveCursesEnter;
	}

	public JTextField getIdTextField() {
		return idTextField;
	}

	public JTextField getfirstNameTextField() {
		return firstNameTextField;
	}

	public void resetIdTextField() {
		idTextField.setText("");
	}

}
