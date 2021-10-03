package Model;

public class Course {

    private String name;
    private double finalGrade;

    public Course(String name, double finalGrade) {
        this.name = name;
        this.finalGrade = finalGrade;
    }

    @Override
    public String toString() {
        return "Name:" + name + " ,Grade:" + finalGrade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course)
            return ((Course) obj).getName().equals(this.name);
        return false;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public String getName() {
        return name;
    }

}
