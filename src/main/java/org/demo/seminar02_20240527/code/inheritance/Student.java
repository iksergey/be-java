package org.demo.seminar02_20240527.code.inheritance;

public class Student extends Person {
    private String schoolName;

    public Student(String fistName, int age, String schoolName) {
        super(fistName, age);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
