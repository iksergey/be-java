package org.demo.summary08_20240802.code;

public class UtilsTest {

    static Utils utils;

    public static void runTest() {
        init();
        isEvenTest1();
        isEvenTest2();
        isEvenTest3();
    }

    public static void init() {
        utils = new Utils();
    }

    public static void isEvenTest1() {
        boolean actual = true;
        boolean result = utils.isEven(4);
        System.out.println("isEvenTest1: " + (actual == result));
    }

    public static void isEvenTest2() {
        boolean actual = false;
        boolean result = utils.isEven(5);
        System.out.println("isEvenTest2: " + (actual == result));
    }

    public static void isEvenTest3() {
        boolean actual = false;
        boolean result = utils.isEven(0);
        System.out.println("isEvenTest3: " + (actual == result));
    }
}
