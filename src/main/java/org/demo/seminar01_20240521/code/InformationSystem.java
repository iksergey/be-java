package org.demo.seminar01_20240521.code;

public class InformationSystem {

    public static void main(String[] args) {

        Person person1 = new Person("John Dou", 17);

        Repository repo = new Repository(10);

        repo.append("Имя 1", 22);
        repo.append(person1);
        repo.append("Имя 2", 23);

        Person person = repo.getPersonById(1);

        Printer printer = new Printer();
        System.out.println();
        printer.printPerson(person);

        for (int i = 0; i < repo.size(); i++) {
            printer.printPerson(repo.getPersonById(i));
        }
    }
}
