package org.demo.seminar03_20240529.code.polymorphism.ex01;

public class Program {
    public static void main(String[] args) {
        MathOperations mathOps = new MathOperations();
        System.out.println(mathOps.add(5, 3)); // Вызов метода add(int, int)
        System.out.println(mathOps.add(5, 3, 2)); // Вызов метода add(int, int, int)
        System.out.println(mathOps.add(5.5, 3.3)); // Вызов метода add(double, double)
    }
}
