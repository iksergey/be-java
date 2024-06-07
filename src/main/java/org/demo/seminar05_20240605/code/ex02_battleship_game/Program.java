package org.demo.seminar05_20240605.code.ex02_battleship_game;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ints = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ints.add(new ArrayList<Integer>());
        }

        System.out.println(ints);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ints.get(i).add(0);
            }
        }

        System.out.println(ints);

        String out = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Integer t = ints.get(i).get(j);
                out += t + " ";
            }
            out += "\n";
        }
        System.out.println(out);

    }
}
