package org.demo.seminar17_20240809.solid.dependency_inversion_principle.ex01;

import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ListStorage storage = new ListStorage();
        new SearchByLastName(storage).search();
        new SearchByFirstName(storage).search();
        new SearchByAge(storage).search();
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class ListStorage {
    private List<Person> storage;

    public ListStorage() {
        storage = new ArrayList<>();
        add(new Person() {
            {
                setLastName("LastName_1");
                setFirstName("FirstName_1");
                setAge(55);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_2");
                setFirstName("FirstName_2");
                setAge(33);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_3");
                setFirstName("FirstName_3");
                setAge(80);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_4");
                setFirstName("FirstName_4");
                setAge(67);
            }
        });
        add(new Person() {
            {
                setLastName("LastName_5");
                setFirstName("FirstName_5");
                setAge(20);
            }
        });
    }

    public List<Person> getPersons() {
        return this.storage;
    }

    public void add(Person p) {
        storage.add(p);
    }
}

class SearchByAge {
    private ListStorage storage;

    public SearchByAge(ListStorage storage) {
        this.storage = storage;
    }

    public void search() {
        List<Person> persons = storage.getPersons();
        for (Person p : persons) {
            if (p.getAge() > 45) {
                System.out.println(p.getFirstName() + " " + p.getAge());
            }
        }
        System.out.println();
    }
}

class SearchByFirstName {
    private ListStorage storage;

    public SearchByFirstName(ListStorage storage) {
        this.storage = storage;
    }

    public void search() {
        List<Person> persons = storage.getPersons();
        for (Person p : persons) {
            if (p.getFirstName().contains("Name_3")) {
                System.out.println(p.getFirstName() + " " + p.getLastName());
            }
        }
        System.out.println();
    }
}

class SearchByLastName {
    private ListStorage storage;

    public SearchByLastName(ListStorage storage) {
        this.storage = storage;
    }

    public void search() {
        List<Person> persons = storage.getPersons();
        for (Person p : persons) {
            if (p.getLastName().contains("_")) {
                System.out.println(p.getFirstName().substring(0, 4) + "...");
            }
        }
        System.out.println();
    }
}
