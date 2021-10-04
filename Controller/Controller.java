package Controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Student;
import Model.StudentMangement;
import View.JFMenu;
import View.JFSearch;
import View.View;

public class Controller {
    private View view;
    private StudentMangement studentMangementSystem;

    public Controller(View view, StudentMangement studentMangementSystem) {
        this.studentMangementSystem = studentMangementSystem;
        this.view = view;
    }

    public Student searchStudent() throws Exception {
        String id = view.getIdTextField().getText();
        Integer.parseInt(id);
        if (id.length() != 9)
            throw new Exception("Invalid id");
        Student student = studentMangementSystem.searchStudentById(id);
        return student;
    }

    public JFMenu getMenuFrame() {
        return view.getMenuFrame();
    }

    public JFSearch getSearchFrame() {
        return view.getSearchFrame();
    }

    public JButton getSearchStudentButton() {
        return view.getSearchStudentButton();
    }

    public JButton getAddStudentButton() {
        return view.getAddStudentButton();
    }

    public JButton getEnterButton() {
        return view.getEnterButton();
    }
}