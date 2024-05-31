package org.demo.seminar03_20240529.code.interfaces;

class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}