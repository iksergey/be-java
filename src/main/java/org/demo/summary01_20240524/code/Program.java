package org.demo.summary01_20240524.code;

public class Program {
    public static void main(String[] args) {
        MoveZerosToEnd toEnd = new MoveZerosToEnd(20);

        System.out.println("Инициализированный массив: " + toEnd.printArray());

        toEnd.fillRandomArray(5);
        System.out.println("Исходный массив: " + toEnd.printArray());

        toEnd.moveZerosToEnd(true);
        System.out.println("Массив после перемещения нулей: " + toEnd.printArray());

    }
}
