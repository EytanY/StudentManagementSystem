package View;

import javax.swing.JButton;
import javax.swing.JTextField;

public class View {
	private JFMenu menuFrame;
	private JFSearch searchFrame;

	public JFMenu getMenuFrame() {
		return menuFrame;
	}

	public JFSearch getSearchFrame() {
		return searchFrame;
	}

	public JButton getSearchStudentButton() {
		return menuFrame.getSearchStudentButton();
	}

	public JButton getAddStudentButton() {
		return menuFrame.getAddStudentButton();
	}

	public JButton getEnterButton() {
		return searchFrame.getEnterButton();
	}

	public JTextField getIdTextField() {
		return searchFrame.getIdTextField();
	}

	public void resetIdTextField() {
		searchFrame.setIdTextField("");
	}

}
