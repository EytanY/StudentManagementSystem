
import javax.swing.*;
import java.time.DateTimeException;
import Controller.Controller;
import Model.Student;
import Model.StudentMangement;
import View.JFStudentManagement;
import View.View;

public class mainApp {
    public static Student student;
    public static JFrame coursesFrame;
    public static JFrame inftoStundetFrame;
    public static JFrame addCourseFrame;
    public static JFrame removeCourseFrame;
    public static JFrame addStudentFrame;
    public static JFrame searchFrame;

    public static void main(String[] args) {
        View view = new View();
        StudentMangement studentMangement = new StudentMangement();
        Controller controller = new Controller(view, studentMangement);
        // Upadate from file
        controller.updateData("Data.dat");

        JFStudentManagement menuFrame = new JFStudentManagement(controller.getLabelForMenu());

        // Return - Menu
        controller.getMenuButton().addActionListener(menu -> {
            if (searchFrame != null)
                searchFrame.dispose();
            if (inftoStundetFrame != null)
                inftoStundetFrame.dispose();
            if (coursesFrame != null)
                coursesFrame.dispose();
            if (addStudentFrame != null)
                addStudentFrame.dispose();
            menuFrame.setVisible(true);
            // return menu
        });

        // Search Student - Page
        controller.getSearchStudentButton().addActionListener(menuSearch -> {
            searchFrame = new JFStudentManagement(controller.getLabelForSearch());
            menuFrame.setVisible(false);
        });

        // Information about student
        controller.getEnterButton().addActionListener(searchEnter -> {
            try {
                student = controller.searchStudent();
                inftoStundetFrame = new JFStudentManagement(controller.getJPanelStundetInfo(student));
                searchFrame.dispose();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
                searchFrame.dispose();
                menuFrame.setVisible(true);
            }
        });

        // Show courses
        controller.getCursesButton().addActionListener(coursesStudent -> {
            inftoStundetFrame.dispose();
            ;
            coursesFrame = new JFStudentManagement(controller.getPanelCurses(student));
        });

        // Add Course - Page
        controller.getAddCursesButton().addActionListener(addCourse -> {
            addCourseFrame = new JFStudentManagement(controller.getLabelAddCourse());
            coursesFrame.dispose();
        });

        // Add Course - Enter
        controller.getAddCursesEnterButton().addActionListener(addCourseEnter -> {
            try {
                if (controller.addCourse(student))
                    JOptionPane.showMessageDialog(null, "Success");
                else
                    JOptionPane.showMessageDialog(null, "Course already exsit");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Grade");
            } finally {
                inftoStundetFrame = new JFStudentManagement(controller.getJPanelStundetInfo(student));
                addCourseFrame.dispose();
            }

        });
        // Remove Course - Page
        controller.getRemoveCursesButton().addActionListener(removeCourse -> {
            removeCourseFrame = new JFStudentManagement(controller.getJLabelRemoveCourse());
            coursesFrame.dispose();
        });

        // Remove Course - Enter
        controller.getRemoveCursesEnterButton().addActionListener(removeCouresEnter -> {
            if (controller.removeCourse(student))
                JOptionPane.showMessageDialog(null, "Success");
            else
                JOptionPane.showMessageDialog(null, "Course not exsit");
            inftoStundetFrame = new JFStudentManagement(controller.getJPanelStundetInfo(student));
            removeCourseFrame.dispose();

        });

        // Add Student - Page
        controller.getAddStudentButton().addActionListener(e -> {
            addStudentFrame = new JFStudentManagement(controller.getJPanelAddStundet());
            menuFrame.setVisible(false);

        });

        // Add Student - Enter
        controller.getAddStudentEnterButton().addActionListener(addStudentEnter -> {
            try {
                if (controller.addStudent())
                    JOptionPane.showMessageDialog(null, "Success");
                else
                    JOptionPane.showMessageDialog(null, "Student's id already exsit");
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Enter integer number please");
            } catch (DateTimeException exception) {
                JOptionPane.showMessageDialog(null, "Invalid birth date");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            } finally {
                menuFrame.setVisible(true);
                addStudentFrame.dispose();
            }

        });

        controller.getExitButton().addActionListener(exit -> {
            // Save
            controller.saveData("Data.dat");
            // Exit
            menuFrame.dispose();
        });
    }

}
