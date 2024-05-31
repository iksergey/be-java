package org.demo.seminar03_20240529.code.polymorphism.ex02;

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}