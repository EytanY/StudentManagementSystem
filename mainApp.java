import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import Controller.Controller;
import Model.Course;
import Model.Student;
import Model.StudentMangement;
import Model.Person.Sex;
import View.View;
import java.awt.Color;

public class mainApp {
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
        Student student2 = new Student("Eytan", "Yeg", "316443878", null, "null", "null", Sex.Male,
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
        JFrame frame = new JFrame();
        JLabel labelForMenu = controller.getLabelForMenu();

        // Search Student button
        controller.getSearchStudentButton().addActionListener(menuSearch -> {
            frame.setVisible(false);
            JFrame searchFrame = new JFrame();
            newFrame(searchFrame);
            searchFrame.add(labelForSearch);
            // Enter - Search the student
            controller.getEnterButton().addActionListener(search -> {
                try {
                    // Student exsit in System
                    Student student = controller.searchStudent();
                    searchFrame.setVisible(false);
                    ;
                    JFrame studentFrame = new JFrame();
                    newFrame(studentFrame);
                    studentFrame.add(controller.getJPanelStundetInfo(student), BorderLayout.CENTER);

                    // Return Menu
                    controller.getMenuButton().addActionListener(menu -> {
                        studentFrame.dispose();
                        frame.setVisible(true);
                    });
                    // Show the courses of student
                    controller.getCursesButton().addActionListener(cursesButto -> {
                        studentFrame.dispose();
                        JFrame cursesFrame = new JFrame();
                        newFrame(cursesFrame);
                        cursesFrame.add(controller.getPanelCurses(student));
                        // Return to Menu
                        controller.getMenuButton().addActionListener(menu -> {
                            cursesFrame.dispose();
                            frame.setVisible(true);
                        });

                        controller.getAddCursesButton().addActionListener(addCourse -> {
                            cursesFrame.dispose();
                            JFrame cursesAddFrame = new JFrame();
                            newFrame(cursesAddFrame);
                            cursesAddFrame.add(controller.getLabelAddCourse());
                            controller.getAddCursesEnterButton().addActionListener(addCourseEnter -> {
                                try {
                                    if (controller.addCourse(student))
                                        JOptionPane.showMessageDialog(null, "Sucsses");
                                    else
                                        JOptionPane.showMessageDialog(null, "Course already exsit");
                                } catch (Exception exception) {
                                    JOptionPane.showMessageDialog(null, "Invalid Input");
                                } finally {
                                    cursesAddFrame.dispose();
                                    frame.setVisible(true);
                                }
                            });
                        });

                        controller.getRemoveCursesButton().addActionListener(removeCourse -> {
                            // Remove course
                            cursesFrame.dispose();
                            JFrame cursesRemoveFrame = new JFrame();
                            newFrame(cursesRemoveFrame);
                            cursesRemoveFrame.add(controller.getJLabelRemoveCourse());

                            // Remove curse enter
                            controller.getRemoveCursesEnterButton().addActionListener(removeCourseEnter -> {
                                if (controller.removeCourse(student))
                                    JOptionPane.showMessageDialog(null, "Sucsses");
                                else
                                    JOptionPane.showMessageDialog(null, "Course not exsit");
                                cursesRemoveFrame.dispose();
                                frame.setVisible(true);
                            });
                        });
                    });
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    searchFrame.dispose();
                    frame.setVisible(true);

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
