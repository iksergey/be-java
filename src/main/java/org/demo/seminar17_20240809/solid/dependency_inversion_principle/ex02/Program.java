package org.demo.seminar17_20240809.solid.dependency_inversion_principle.ex02;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        DictionaryStorage storage = new DictionaryStorage();
        new SearchByLastName(storage).search();
        new SearchByFirstName(storage).search();
        new SearchByAge(storage).search();
    }
}

class DictionaryStorage {
    private Map<String, Person> storage;

    public DictionaryStorage() {
        storage = new HashMap<>();
        add("SingleResponsibility", new Person("FirstName_1", "LastName_1", 55));
        add("OpenClosed", new Person("FirstName_2", "LastName_2", 33));
        add("LiskovSubstitution", new Person("FirstName_3", "LastName_3", 80));
        add("InterfaceSegregation", new Person("FirstName_4", "LastName_4", 67));
        add("DependencyInversion", new Person("FirstName_5", "LastName_5", 20));
    }

    public Map<String, Person> getPersons() {
        return this.storage;
    }

    public void add(String key, Person p) {
        storage.put(key, p);
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

class SearchByAge {
    private DictionaryStorage storage;

    public SearchByAge(DictionaryStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.getPersons().values()) {
            if (p.getAge() > 45) {
                System.out.println(p.getFirstName() + " " + p.getAge());
            }
        }
        System.out.println();
    }
}

class SearchByFirstName {
    private DictionaryStorage storage;

    public SearchByFirstName(DictionaryStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.getPersons().values()) {
            if (p.getFirstName().contains("Name_3")) {
                System.out.println(p.getFirstName() + " " + p.getLastName());
            }
        }
        System.out.println();
    }
}

class SearchByLastName {
    private DictionaryStorage storage;

    public SearchByLastName(DictionaryStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.getPersons().values()) {
            if (p.getLastName().contains("_")) {
                System.out.println(p.getFirstName().substring(0, 4) + "...");
            }
        }
        System.out.println();
    }
}
