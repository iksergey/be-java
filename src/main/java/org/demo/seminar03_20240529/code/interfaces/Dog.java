package org.demo.seminar03_20240529.code.interfaces;

class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}