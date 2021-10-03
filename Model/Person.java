package Model;

import java.time.LocalDate;

public abstract class Person {
    public enum Sex {
        Male, Female
    }

    private String id, firstName, lastName, fatherName, motherName;
    private LocalDate birthDate;
    private int age;
    private Sex sex;

    public Person(String firstName, String lastName, String id, LocalDate birthDate, String fatherName,
            String motherName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.sex = sex;
        age = calcAge();
    }

    public int calcAge() {
        LocalDate currentDate = LocalDate.now();
        currentDate.minusDays(birthDate.getDayOfMonth());
        currentDate.minusMonths(birthDate.getMonthValue());
        currentDate.minusYears(birthDate.getYear());
        return currentDate.getYear();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person)
            return ((Person) obj).getId().equals(this.id);
        return false;
    }

    @Override
    public String toString() {
        return String.format("Name:%s %s ,ID:%s ", firstName, lastName, id);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

}
