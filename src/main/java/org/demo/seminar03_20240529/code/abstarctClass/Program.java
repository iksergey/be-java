package org.demo.seminar03_20240529.code.abstarctClass;

public class Program {
    public static void main(String[] args) {
        Animal dog = new Dog("Шарик");
        Animal cat = new Cat("Барсик");
        dog.makeSound();
        cat.makeSound();
    }
}