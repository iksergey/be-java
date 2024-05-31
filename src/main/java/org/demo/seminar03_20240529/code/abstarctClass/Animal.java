package org.demo.seminar03_20240529.code.abstarctClass;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void sleep() {
        System.out.println(name + " спит.");
    }
}