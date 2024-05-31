package org.demo.seminar03_20240529.code.interfaces;

interface Animal {
    String DEFAULT_SOUND = "default sound";

    void makeSound();

    default void sleep() {
        System.out.println("животное спит.");
    }

    static void describe() {
        System.out.println("Описание.");
    }
}