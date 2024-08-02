package org.demo.summary08_20240802.code;

public class ProgramTest {

    private static Program program;

    public static void runTest() {
        init();
        sumTest1();
        sumTest2();
        sumTest3();
        sumTest4();
    }

    private static void init() {
        program = new Program();
    }

    private static void sumTest1() {
        double actual = 0.5;
        double result = program.sum(1, 2);
        System.out.println("sumTest1: " + (actual == result));
    }

    private static void sumTest2() {
        double actual = 5.0;
        double result = program.sum(10, 2);
        System.out.println("sumTest2: " + (actual == result));
    }

    private static void sumTest3() {
        double actual = 5.0;
        double result = program.sum(-10, -2);
        System.out.println("sumTest3: " + (actual == result));
    }

    private static void sumTest4() {
        try {
            program.sum(-10, 0);
        } catch (ArithmeticException e) {
            System.out.println("sumTest4: " + true);
            return;
        }
        System.out.println("sumTest4: " + (false));
    }
}
