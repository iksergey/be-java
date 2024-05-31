package org.demo.seminar02_20240527.code.inheritance;

public class Person {
    private String fistName;
    private int age;

    protected Person(String fistName, int age) {
        this.fistName = fistName;
        this.age = age;
    }

    public String getFistName() {
        System.out.println(fistName);
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }
}
