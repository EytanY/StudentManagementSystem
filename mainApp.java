import javax.swing.JFrame;
<<<<<<< HEAD
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Controller.Controller;
import Model.Student;
import Model.StudentMangement;
import Model.Person.Sex;
import View.JFMenu;
import View.JFSearch;
import View.View;

public class mainApp {

    // public static View view = new View();
    public static StudentMangement studentMangementSystem = new StudentMangement();
    // public static Controller controller = new Controller(view,
    // studentMangementSystem);

    public static void main(String[] args) {
        JFMenu menuFrame = new JFMenu();
        // Student s = new Student("firstName", "lastName", "316443878", null,
        // "fatherName", "motherName", Sex.Male,
        // "email");
        // studentMangementSystem.addStudent(s);

        // controller.getAddStudentButton().addActionListener(e -> {
        // Add Student
        // });

        // controller.getSearchStudentButton().addActionListener(e -> {
        // Change Label
        // menuFrame.dispose();
        // JFSearch searchMenu = controller.getSearchFrame();

        // Do if the user click on search
        // controller.getEnterButton().addActionListener(search -> {
        // try {
        // Student student = controller.searchStudent();
        // frame.dispose();
        // } catch (Exception exception) {
        // JOptionPane.showMessageDialog(null, "Invaid input");
        // labelForMenu.setVisible(true);
        // labelForSearchStudent.setVisible(false);

        // }
        // });
        // });}
=======
import java.awt.Color;
import View.ViewMenu;

public class mainApp {
    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();

        JFrame frame = new JFrame();
        frame.add(viewMenu.getJLabelForMenu());

        frame.setVisible(true);
        frame.setSize(450, 450);
        frame.setResizable(false);
        frame.setTitle("Student Mangement System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(229, 230, 204));
>>>>>>> parent of a2c60f3 (Controller)
    }
}
