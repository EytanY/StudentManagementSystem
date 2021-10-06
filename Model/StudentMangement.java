package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class StudentMangement implements Serializable {
    private ArrayList<Student> students;

    public StudentMangement() {
        students = new ArrayList<Student>();
    }

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.equals(student))
                return false;
        }
        students.add(student);
        return true;
    }

    public boolean subStudent(Student student) {
        return students.remove(student);
    }

    public boolean addCourseForStudent(Student student, Course course) {
        return student.addCourse(course);
    }

    public boolean removeCourseForStudent(Student student, Course course) {
        return student.removeCourse(course);
    }

    public Student searchStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id))
                return student;
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void save(String path) throws IOException, ClassNotFoundException {
        ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(path));
        StudentMangement system = new StudentMangement();
        system.setStudents(this.students);
        outFile.writeObject(system);
        outFile.close();
    }

    public void update(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path));
        StudentMangement system = (StudentMangement) inFile.readObject();
        setStudents(system.getStudents());
        inFile.close();
    }

}
