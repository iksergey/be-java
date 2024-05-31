package org.demo.seminar02_20240527.code.inheritance;

public class Teacher extends Person {
    private String subject;

    public Teacher(String fistName, int age, String subject) {
        super(fistName, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
