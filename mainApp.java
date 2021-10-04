import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import Controller.Controller;
import Model.Student;
import Model.StudentMangement;
import Model.Person.Sex;
import View.View;
import java.awt.Color;

public class mainApp {
    public static void main(String[] args) {
        View view = new View();
        StudentMangement studentMangement = new StudentMangement();
        studentMangement.addStudent(
                new Student("Eytan", "Yeg", "316443878", null, "null", "null", Sex.Male, "etan173@gmail.com"));
        Controller controller = new Controller(view, studentMangement);

        JLabel labelForSearch = controller.getLabelForSearch();
        JFrame frame = new JFrame();
        JLabel labelForMenu = controller.getLabelForMenu();

        controller.getSearchStudentButton().addActionListener(e -> {
            frame.dispose();
            JFrame searchFrame = new JFrame();
            newFrame(searchFrame);
            searchFrame.add(labelForSearch);

            controller.getEnterButton().addActionListener(search -> {
                try {
                    Student student = controller.searchStudent();
                    searchFrame.dispose();
                    JFrame studentFrame = new JFrame();
                    newFrame(studentFrame);
                    studentFrame.add(controller.getJPanelStundetInfo(student), BorderLayout.CENTER);

                    controller.getMenuButton().addActionListener(menu -> {
                        studentFrame.dispose();
                        frame.show();
                    });

                    controller.getCursesButton().addActionListener(cursesButto -> {
                        // Panel show all Cureses + input - remove or create
                    });
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    searchFrame.dispose();
                    frame.show();
                }
            });

            controller.getEnterButton().addActionListener(search -> {
                // Do For search
            });
        });

        controller.getAddStudentButton().addActionListener(e -> {
            // Add Student
        });
        frame.add(labelForMenu);
        newFrame(frame);
    }

    public static void newFrame(JFrame frame) {
        frame.setVisible(true);
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.setTitle("Student Mangement System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400, 70);
        frame.getContentPane().setBackground(new Color(229, 230, 204));
    }
}
