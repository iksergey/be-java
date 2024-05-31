package org.demo.seminar03_20240529.code.abstarctClass;

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }
}