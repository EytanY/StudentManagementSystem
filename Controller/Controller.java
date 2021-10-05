package Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Course;
import Model.Student;
import Model.StudentMangement;
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
        Student student = studentMangementSystem.searchStudentById(id);
        if (id.length() != 9 || student == null)
            throw new Exception("Invalid id");
        return student;
    }

    public boolean removeCourse(Student student) {
        String name = view.getfirstNameTextField().getText();
        Course course = student.searchCourseByName(name);
        if (course == null) {
            return false;
        }
        return studentMangementSystem.removeCourseForStudent(student, course);

    }

    public JPanel getJPanelStundetInfo(Student student) {
        return view.getPanelInfo(student);
    }

    public JScrollPane getPanelCurses(Student student) {
        return view.getPanelOfCurses(student);
    }

    public JLabel getLabelForMenu() {
        return view.getJLabelForMenu();
    }

    public JLabel getJLabelRemoveCourse() {
        return view.getLabelRemoveCourse();
    }

    public JLabel getLabelForSearch() {
        return view.getLabelForSearchStudent();
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

    public JButton getMenuButton() {
        return view.getMenuButton();
    }

    public JButton getCursesButton() {
        return view.getCursesButton();
    }

    public JButton getAddCursesButton() {
        return view.getAddCursesButton();
    }

    public JButton getRemoveCursesButton() {
        return view.getRemoveButton();
    }

    public JButton getRemoveCursesEnterButton() {
        return view.getRemoveEnterButton();
    }

}
