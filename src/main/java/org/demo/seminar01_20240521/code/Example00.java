package org.demo.seminar01_20240521.code;

import java.util.Random;

public class Example00 {
    private static final int COUNT = 10;
    private static int index = 0;
    private static String[] names = new String[COUNT];
    private static int[] ages = new int[COUNT];

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < COUNT; i++) {
            int age = random.nextInt(71) + 10;
            createPerson("Имя " + i, age);
            String[] person = getPersonById(i);
            printPersonById(person);
        }

        // Пример изменения данных о человеке
        // updatePersonById(2, "Новое имя", 60);
        // printPersonById(2);
    }

    private static void createPerson(String personName, int personAge) {
        if (index >= COUNT)
            return;
        names[index] = personName;
        ages[index] = personAge;
        index += 1;
    }

    private static String[] getPersonById(int id) {
        if (id < 0 || id >= index)
            return new String[] { "empty", Integer.toString(-1) };
        return new String[] { names[id], Integer.toString(ages[id]) };
    }

    private static void printPersonById(int id) {
        if (id < 0 || id >= index)
            return;
        System.out.println("Имя: " + names[id] + " возраст: " + ages[id]);
    }

    private static void printPersonById(String[] personInfo) {
        System.out.printf("Имя: %s возраст: %s\n", personInfo[0], personInfo[1]);
    }

    private static void updatePersonById(int id, String newName, int newAge) {
        if (id < 0 || id >= index)
            return;
        names[id] = newName;
        ages[id] = newAge;
    }
}