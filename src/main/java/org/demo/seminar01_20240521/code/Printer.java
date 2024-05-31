package org.demo.seminar01_20240521.code;

public class Printer {
    public void printPerson(Person person) {
        System.out.printf("Имя: %s возраст: %d\n", person.getName(), person.getAge());
    }
}
