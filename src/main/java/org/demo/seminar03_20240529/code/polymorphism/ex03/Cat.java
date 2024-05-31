package org.demo.seminar03_20240529.code.polymorphism.ex03;

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}