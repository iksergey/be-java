package org.demo.seminar03_20240529.code.abstarctClass;

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}