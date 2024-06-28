package org.demo.summary06_20240628.code;

import java.util.ArrayList;
import java.util.Random;

public class Numbers {
    public static void main(String[] args) {
        Random random = new Random(0);
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            li.add(random.nextInt(10));
        }
        System.out.println(li);

        // ArrayList<Integer> res = new ArrayList<>();

        // for (Integer el : li) {
        // if (el % 2 == 0)
        // res.add(el);
        // }
        ArrayList<Integer> res = where(li, e -> e % 2 == 0);
        System.out.println(res);

        res.clear();

        // for (Integer el : li) {
        // if (el % 3 == 0)
        // res.add(el);
        // }
        res = where(li, e -> e % 3 == 0);
        System.out.println(res);

        res = where(li, e -> e > 5);
        System.out.println(res);
    }

    static ArrayList<Integer> where(ArrayList<Integer> data, Condition op) {
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer el : data) {
            if (op.check(el))
                res.add(el);
        }
        return res;
    }
}

@FunctionalInterface
interface Condition {
    boolean check(int item);
}

@FunctionalInterface
interface Foo {
    int[] check(String[] item);
}
