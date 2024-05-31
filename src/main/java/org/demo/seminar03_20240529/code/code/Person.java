package org.demo.seminar03_20240529.code.code;

public class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.salary = 0;
    }

    public Person(String name, int age, double salary) {
        this.name = name;

        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
