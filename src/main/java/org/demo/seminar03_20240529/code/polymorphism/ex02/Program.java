package org.demo.seminar03_20240529.code.polymorphism.ex02;

public class Program {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound();
        myCat.makeSound();
    }
}
