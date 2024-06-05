package org.demo.seminar05_20240605.code.ex01;

public class Program {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.append(1);
        storage.append(2);
        storage.appendRange(new int[] { 3, 4, 5 });
        System.out.println(storage); // [1 2 3 4 5]

        storage.remove(3);
        System.out.println(storage); // [1 2 4 5]

        storage.removeAt(1);
        System.out.println(storage);// [1 4 5]

        System.out.println(storage.get(1)); // 4

        System.out.println(storage.size());// 3

        System.out.println(storage.contains(4)); // true
        System.out.println(storage.contains(3)); // false
    }
}
