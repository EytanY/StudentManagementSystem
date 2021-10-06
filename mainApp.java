
import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;
import Controller.Controller;
import Model.Student;
import Model.StudentMangement;
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

        JFrame frame = new JFrame();
        JLabel labelForMenu = controller.getLabelForMenu();

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
            frame.setVisible(true);
            // return menu
        });

        // Search Student - Page
        controller.getSearchStudentButton().addActionListener(menuSearch -> {
            searchFrame = new JFrame();
            newFrame(searchFrame, true);
            searchFrame.add(controller.getLabelForSearch());
            frame.setVisible(false);
        });

        // Information about student
        controller.getEnterButton().addActionListener(searchEnter -> {
            try {
                student = controller.searchStudent();
                inftoStundetFrame = new JFrame();
                newFrame(inftoStundetFrame, true);
                inftoStundetFrame.add(controller.getJPanelStundetInfo(student), BorderLayout.CENTER);
                searchFrame.dispose();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
                searchFrame.dispose();
                frame.setVisible(true);
            }
        });

        controller.getCursesButton().addActionListener(coursesStudent -> {
            inftoStundetFrame.setVisible(false);
            coursesFrame = new JFrame();
            newFrame(coursesFrame, true);
            coursesFrame.add(controller.getPanelCurses(student));
            // show courses

        });
        // Add Course - Page
        controller.getAddCursesButton().addActionListener(addCourse -> {
            addCourseFrame = new JFrame();
            newFrame(addCourseFrame, true);
            addCourseFrame.add(controller.getLabelAddCourse());
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
                inftoStundetFrame = new JFrame();
                newFrame(inftoStundetFrame, true);
                inftoStundetFrame.add(controller.getJPanelStundetInfo(student), BorderLayout.CENTER);
                addCourseFrame.dispose();
            }

        });
        // Remove Course - Page
        controller.getRemoveCursesButton().addActionListener(removeCourse -> {
            removeCourseFrame = new JFrame();
            newFrame(removeCourseFrame, true);
            removeCourseFrame.add(controller.getJLabelRemoveCourse());
            coursesFrame.dispose();
        });

        // Remove Course - Enter
        controller.getRemoveCursesEnterButton().addActionListener(removeCouresEnter -> {
            if (controller.removeCourse(student))
                JOptionPane.showMessageDialog(null, "Success");
            else
                JOptionPane.showMessageDialog(null, "Course not exsit");
            inftoStundetFrame = new JFrame();
            newFrame(inftoStundetFrame, true);
            inftoStundetFrame.add(controller.getJPanelStundetInfo(student), BorderLayout.CENTER);
            removeCourseFrame.dispose();

        });

        // Add Student - Page
        controller.getAddStudentButton().addActionListener(e -> {
            addStudentFrame = new JFrame();
            newFrame(addStudentFrame, true);
            addStudentFrame.add(controller.getJPanelAddStundet());
            frame.setVisible(false);

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
                frame.setVisible(true);
                addStudentFrame.dispose();
            }

        });

        controller.getExitButton().addActionListener(exit -> {
            // Save
            controller.saveData("Data.dat");
            // Exit
            frame.dispose();
        });
        frame.add(labelForMenu);
        newFrame(frame, true);
    }

    public static void newFrame(JFrame frame, boolean bool) {
        frame.setVisible(bool);
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.setTitle("Student Mangement System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400, 70);
        frame.getContentPane().setBackground(new Color(229, 230, 204));
    }

}
