package org.demo.seminar11_20240701.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.stream()
                .skip(3)
                .collect(Collectors.toList());

        for (int i = 0; i < 10; i++) {
            list.add(i * 100);
        }

        System.out.println(list);
    }
}
