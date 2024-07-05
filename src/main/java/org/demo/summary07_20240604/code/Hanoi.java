package org.demo.summary07_20240604.code;

public class Hanoi {
    public static void main(String[] args) {
        hanoiGame(3, 1, 3, 2);
    }

    static void hanoiGame(int q, int from, int to, int buf) {
        if (q == 0)
            return;
        hanoiGame(q - 1, from, buf, to);
        System.out.println(from + " -> " + to);
        hanoiGame(q - 1, buf, to, from);
    }
}
