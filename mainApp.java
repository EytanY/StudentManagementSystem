
import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;

import Controller.Controller;
import Model.Course;
import Model.Student;
import Model.StudentMangement;
import Model.Person.Sex;
import View.View;

public class mainApp {
    public static Student student;
    public static JFrame coursesFrame;
    public static JFrame inftoStundetFrame;
    public static JFrame addCourseFrame;
    public static JFrame removeCourseFrame;
    public static JFrame addStudentFrame;

    public static void main(String[] args) {
        View view = new View();
        StudentMangement studentMangement = new StudentMangement();
        Course c1 = new Course("Java", 95);
        Course c2 = new Course("Java2", 95);
        Course c3 = new Course("JS", 100);
        Course c4 = new Course("AS", 45);
        Course c5 = new Course("C++", 95);
        Course c6 = new Course("Math", 95);
        Course c12 = new Course("Math2", 55);
        Course c11 = new Course("ALG", 34);
        Course c10 = new Course("SQL", 95);
        Course c9 = new Course("LINUX", 65);
        Course c8 = new Course("li", 95);
        Course c7 = new Course("Te", 95);
        Course c13 = new Course("Te", 95);
        Course c14 = new Course("Te22", 95);
        Course c15 = new Course("Te21", 95);
        Course c16 = new Course("Te2122", 95);
        Course c17 = new Course("Te212222", 95);
        Student student2 = new Student("Eytan", "Yeg", "316443878", LocalDate.of(1997, 3, 17), "null", "null", Sex.Male,
                "etan173@gmail.com");

        studentMangement.addStudent(student2);

        studentMangement.addCourseForStudent(student2, c1);
        studentMangement.addCourseForStudent(student2, c2);
        studentMangement.addCourseForStudent(student2, c3);
        studentMangement.addCourseForStudent(student2, c4);
        studentMangement.addCourseForStudent(student2, c5);
        studentMangement.addCourseForStudent(student2, c6);
        studentMangement.addCourseForStudent(student2, c7);
        studentMangement.addCourseForStudent(student2, c8);
        studentMangement.addCourseForStudent(student2, c9);
        studentMangement.addCourseForStudent(student2, c10);
        studentMangement.addCourseForStudent(student2, c11);
        studentMangement.addCourseForStudent(student2, c12);
        studentMangement.addCourseForStudent(student2, c13);
        studentMangement.addCourseForStudent(student2, c14);
        studentMangement.addCourseForStudent(student2, c15);
        studentMangement.addCourseForStudent(student2, c16);
        studentMangement.addCourseForStudent(student2, c17);
        Controller controller = new Controller(view, studentMangement);

        JLabel labelForSearch = controller.getLabelForSearch();
        JFrame frameSearch = new JFrame();
        newFrame(frameSearch, false);
        frameSearch.setVisible(false);
        frameSearch.add(labelForSearch);
        JFrame frame = new JFrame();
        JLabel labelForMenu = controller.getLabelForMenu();

        // Return - Menu
        controller.getMenuButton().addActionListener(menu -> {
            frameSearch.setVisible(false);
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
            frame.setVisible(false);
            frameSearch.setVisible(true);
        });

        // Information about student
        controller.getEnterButton().addActionListener(searchEnter -> {
            try {
                student = controller.searchStudent();
                inftoStundetFrame = new JFrame();
                newFrame(inftoStundetFrame, true);
                inftoStundetFrame.add(controller.getJPanelStundetInfo(student), BorderLayout.CENTER);
                frameSearch.setVisible(false);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
                frameSearch.setVisible(false);
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
