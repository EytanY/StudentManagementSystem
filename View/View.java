package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class View {

	private Button bSearchStudent = new Button("Search Student");
	private Button bAddStudent = new Button("Add Student");
	private Button bCreateStudent = new Button("Add Student");
	private TextField firstNameTextField, lastNameTextField, idTextField, fatherNameTextField, motherNameTextField;

	public Scene getMenuScene() {
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(5));
		Text menuText = new Text("Student Management System:");
		Text enterIdText = new Text("Please Enter Student's ID:");
		vb.getChildren().addAll(menuText, enterIdText, idTextField, bSearchStudent, bAddStudent);
		return new Scene(vb, 500, 500);
	}

	public Scene getAddStudentScene() {
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(5));
		Text addStudentText = new Text("Add Student:");
		Text enterFirstNameText = new Text("Enter first name:");
		Text enterLastNameText = new Text("Enter last name:");
		Text enterIdText = new Text("Enter id:");
		Text enterFatherNameText = new Text("Enter father's name:");
		Text enterMotherNameText = new Text("Enter mother's name:");

		return new Scene(vb, 500, 500);
	}

	// buttons on menu
	// text on menu
	// public getMenuScene
}
