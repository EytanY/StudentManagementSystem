package Model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Student extends Person {
    private String email;
    private ArrayList<Course> courses;
    private double averageGrade;
    private ImageIcon photo;

    public Student(String firstName, String lastName, String id, LocalDate birthDate, String fatherName,
            String motherName, Sex sex, String email, ImageIcon photo) {
        super(firstName, lastName, id, birthDate, fatherName, motherName, sex);
        this.email = email;
        this.photo = photo;
        courses = new ArrayList<Course>();
        averageGrade = 0;
    }

    public void clacAverage() {
        double average = 0;
        for (Course c : courses) {
            average += c.getFinalGrade();
        }
        this.averageGrade = average / courses.size();
    }

    public boolean addCourse(Course course) {
        for (Course c : courses) {
            if (c.equals(course))
                return false;
        }
        courses.add(course);
        clacAverage();
        return true;
    }

    public boolean subCourseByName(String name) {
        Course course = searchCourseByName(name);
        if (course != null) {
            courses.remove(course);
            return true;
        }
        return false;
    }

    public Course searchCourseByName(String name) {
        name = name.toLowerCase();
        for (Course course : courses) {
            if (course.getName().equals(name))
                return course;
        }
        return null;
    }

    public boolean removeCourse(Course course) {
        if (courses.remove(course)) {
            clacAverage();
            return true;
        }
        return false;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public double getAverage() {
        return averageGrade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

}
