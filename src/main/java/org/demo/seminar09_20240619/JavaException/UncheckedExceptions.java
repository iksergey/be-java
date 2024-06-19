package org.demo.seminar09_20240619.JavaException;

import java.util.Scanner;

public class UncheckedExceptions {
    static String str = "null";

    static void strNull() {
        str = null;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int div = new Scanner(System.in).nextInt();
        double a = 10 / div; // ArithmeticException

        System.out.println(a);
        strNull();
        // String str = null;
        System.out.println(str.length()); // NullPointerException
        NullPointerException
        System.out.println("end");
    }
}
