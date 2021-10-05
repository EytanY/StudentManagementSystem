package Controller;

import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Model.Course;
import Model.Student;
import Model.StudentMangement;
import Model.Person.Sex;
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
        String name = view.getCourseNameTextField().getText();
        Course course = student.searchCourseByName(name);
        if (course == null) {
            return false;
        }
        return studentMangementSystem.removeCourseForStudent(student, course);

    }

    public boolean addCourse(Student student) throws Exception {
        String name = view.getCourseNameTextField().getText();
        double finalGrade = Double.parseDouble(view.getGradeCourseTextField().getText());
        if (finalGrade > 100 || finalGrade < 0 || name.length() == 0)
            throw new Exception();
        Course course = new Course(name, finalGrade);

        return student.addCourse(course);
    }

    public boolean addStudent() throws Exception {
        String firstName = view.getfirstNameTextField().getText();
        String lastName = view.getLastNameTextField().getText();
        String id = view.getIdAddTextField().getText();

        if (id.length() != 9 || id.length() == 0)
            throw new Exception("Invalid id");
        Integer.parseInt(id);

        String fatherName = view.getFatherNameTextField().getText();
        String motherName = view.getMotherNameTextField().getText();
        if (firstName.length() < 2 || lastName.length() < 2 || motherName.length() < 2 || fatherName.length() < 2)
            throw new Exception("Invalid name");

        String email = view.getEmailTextField().getText();
        if (!(isEmail(email)))
            throw new Exception("Invalid email");

        Sex sexStudent = view.getGender();
        int year = Integer.parseInt(view.getYearTextField().getText());
        int month = Integer.parseInt(view.getMonthTextField().getText());
        int day = Integer.parseInt(view.getDayTextField().getText());
        LocalDate birthDate = LocalDate.of(year, month, day);
        // For valid of Date
        Student student = new Student(firstName, lastName, id, birthDate, fatherName, motherName, sexStudent, email);
        if (student.getAge() < 16 && student.getAge() > 0)
            throw new Exception("The student is too young(under 16)");
        if (student.getAge() < 0 || student.getAge() > 120)
            throw new Exception("Invalid birth date");
        return studentMangementSystem
                .addStudent(new Student(firstName, lastName, id, birthDate, fatherName, motherName, sexStudent, email));
    }

    public JPanel getJPanelStundetInfo(Student student) {
        return view.getPanelInfo(student);
    }

    public JPanel getJPanelAddStundet() {
        return view.getPanelAddStundet();
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

    public JLabel getLabelAddCourse() {
        return view.getLabelAddCourse();
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

    public JButton getAddCursesEnterButton() {
        return view.getAddEnterButton();
    }

    public JButton getExitButton() {
        return view.getExitButton();
    }

    public JButton getAddStudentEnterButton() {
        return view.getAddStudentEnterButton();
    }

    public boolean isEmail(String s) {
        return s.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
    }

}
