import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.Controller;
import Model.Student;
import Model.StudentMangement;
import Model.Person.Sex;

import java.awt.Color;

import View.View;

public class mainApp {

    public static JFrame frame;
    public static View view = new View();
    public static StudentMangement studentMangementSystem = new StudentMangement();
    // public static Controller controller = new Controller(view,
    // studentMangementSystem);

    public static void main(String[] args) {
        Student s = new Student("firstName", "lastName", "316443878", null, "fatherName", "motherName", Sex.Male,
                "email");
        studentMangementSystem.addStudent(s);

        Controller controller = new Controller(view, studentMangementSystem);

        JLabel label = view.getJLabelForMenu();

        controller.getAddStudentButton().addActionListener(e -> {
            // Add Student
        });

        controller.getSearchStudentButton().addActionListener(e -> {
            label.setVisible(false);
            frame.add(view.getLabelForSearchStudent());

            controller.getEnterButton().addActionListener(search -> {
                try {
                    Student student = controller.searchStudent();
                    System.out.println(student);
                } catch (Exception exception) {
                    System.out.println("Erro");

                }
            });
        });

        frame = new JFrame();
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(450, 450);
        frame.setResizable(false);
        frame.setTitle("Student Mangement System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(229, 230, 204));
    }
}
