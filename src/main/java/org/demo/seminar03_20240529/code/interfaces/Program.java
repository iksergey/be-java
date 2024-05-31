package org.demo.seminar03_20240529.code.interfaces;

public class Program {
    public static void main(String[] args) {
        Animal.describe();

        Animal dog = new Dog("Шарик");
        Animal cat = new Cat("Барсик");

        dog.makeSound();
        dog.sleep();

        cat.makeSound();
        cat.sleep();

    }
}