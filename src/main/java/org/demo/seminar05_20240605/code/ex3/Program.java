package org.demo.seminar05_20240605.code.ex3;

public class Program {
    public static void main(String[] args) {

        RubberArray ra = new RubberArray();
        ra.append(1);
        ra.append(2);
        ra.append(3);
        ra.append(5);
        // System.out.println(ra);

        for (int i : ra) {
            System.out.println(i);
        }
    }
}
