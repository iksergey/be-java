package org.demo.seminar17_20240809.solid.dependency_inversion_principle.ex03;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        System.out.println("DictionaryStorage:");
        FindStorage dictionaryStorage = new DictionaryStorage();
        new SearchByLastName(dictionaryStorage).search();
        new SearchByFirstName(dictionaryStorage).search();
        new SearchByAge(dictionaryStorage).search();

        System.out.println("ListStorage:");
        FindStorage listStorage = new ListStorage();
        new SearchByLastName(listStorage).search();
        new SearchByFirstName(listStorage).search();
        new SearchByAge(listStorage).search();
    }
}

interface FindStorage {
    List<Person> findAll(Predicate<Person> predicate);
}

class DictionaryStorage implements FindStorage {
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

    @Override
    public List<Person> findAll(Predicate<Person> predicate) {
        return storage.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}

class ListStorage implements FindStorage {
    private List<Person> storage;

    public ListStorage() {
        storage = new ArrayList<>();
        add(new Person("FirstName_1", "LastName_1", 55));
        add(new Person("FirstName_2", "LastName_2", 33));
        add(new Person("FirstName_3", "LastName_3", 80));
        add(new Person("FirstName_4", "LastName_4", 67));
        add(new Person("FirstName_5", "LastName_5", 20));
    }

    public List<Person> getPersons() {
        return this.storage;
    }

    public void add(Person p) {
        storage.add(p);
    }

    @Override
    public List<Person> findAll(Predicate<Person> predicate) {
        return storage.stream()
                .filter(predicate)
                .collect(Collectors.toList());
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
    private FindStorage storage;

    public SearchByAge(FindStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.findAll(e -> e.getAge() > 45)) {
            System.out.println(p.getFirstName() + " " + p.getAge());
        }
        System.out.println();
    }
}

class SearchByFirstName {
    private FindStorage storage;

    public SearchByFirstName(FindStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.findAll(e -> e.getFirstName().contains("Name_3"))) {
            System.out.println(p.getFirstName() + " " + p.getAge());
        }
        System.out.println();
    }
}

class SearchByLastName {
    private FindStorage storage;

    public SearchByLastName(FindStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.findAll(e -> e.getLastName().contains("_"))) {
            System.out.println(p.getFirstName().substring(0, 4) + "...");
        }
        System.out.println();
    }
}
