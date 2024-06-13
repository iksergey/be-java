package org.demo.summary04_20240614.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Performance {
    public static void main(String[] args) {
        int size = 100_000;
        List<Integer> list = new ArrayList<>(size);
        Set<Integer> set = new HashSet<>(size);

        long startTimeList = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTimeList = System.nanoTime();
        long listTime = endTimeList - startTimeList;

        long startTimeSet = System.nanoTime();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        long endTimeSet = System.nanoTime();
        long setTime = endTimeSet - startTimeSet;

        System.out.println("Время добавления в ArrayList: " + listTime / 1000000.0 + " ms");
        System.out.println("Время добавления в HashSet: " + setTime / 1000000.0 + " ms");

        // ===

        startTimeList = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.contains(i);
        }
        endTimeList = System.nanoTime();
        listTime = endTimeList - startTimeList;

        startTimeSet = System.nanoTime();
        for (int i = 0; i < size; i++) {
            set.contains(i);
        }
        endTimeSet = System.nanoTime();
        setTime = endTimeSet - startTimeSet;

        System.out.println("Время поиска в ArrayList: " + listTime / 1000000.0 + " ms");
        System.out.println("Время поиска в HashSet: " + setTime / 1000000.0 + " ms");
    }
}
