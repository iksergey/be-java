package org.demo.seminar11_20240701.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();

        // for (int i = 0; i < 3; i++) {
        // list.add(i);
        // }

        // List<Integer> res = bar(list, x -> x + 1);

        // System.out.println(res); // 1 2 3

        // for (int i = 0; i < 3; i++) {
        // list.add(10 * i);
        // }

        // System.out.println(res); // 1 2 3

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        Stream<Integer> res = list
                .stream()
                // .peek(System.out::println)
                .map(x -> x + 1)
                // .peek(System.out::println)
                .map(x -> 1000 + x)
                // .peek(System.out::println)
                .filter(x -> x % 2 == 0);
        // .collect(Collectors.toList());

        // System.out.println(Arrays.toString(res.toArray()));

        for (int i = 0; i < 3; i++) {
            list.add(10 * i);
        }

        System.out.println(Arrays.toString(res.toArray()));

        Foo foo = new Foo();

        System.out.println(foo.getBar().value);
        System.out.println(foo.getBar().value);
    }

    static List<Integer> bar(List<Integer> in, DoIt it) {
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            out.add(it.apply(in.get(i)));
        }
        return out;
    }
}

class Foo {
    private Bar bar;

    public Bar getBar() {
        if (this.bar == null)
            this.bar = new Bar();
        bar.value++;
        return bar;
    }
}

class Bar {
    int value;
}

@FunctionalInterface
interface DoIt {
    int apply(int x);
}
