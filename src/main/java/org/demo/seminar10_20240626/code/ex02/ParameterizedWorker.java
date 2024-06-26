package org.demo.seminar10_20240626.code.ex02;

public class ParameterizedWorker<E> {
    private E id;

    public String firstName;
    public String lastName;
    public int age;
    public int salary;

    public ParameterizedWorker(E id, String firstName,
            String lastName,
            int age,
            int salary) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;

    }

    public String getId() {
        return String.format("%s", id);
    }

    public String fullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
