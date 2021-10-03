package Model;

import java.util.ArrayList;

public class StudentMangement {
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

}
