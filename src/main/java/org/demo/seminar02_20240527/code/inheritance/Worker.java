package org.demo.seminar02_20240527.code.inheritance;

public class Worker extends Person {
    private int salary;

    public Worker(String fistName, int age, int salary) {
        super(fistName, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
