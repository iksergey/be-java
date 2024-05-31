package org.demo.summary02_20240531.code;

public class Program {
    public static void main(String[] args) {
        Calc calc = new Calc();
        Div div = new Div();
        Sum sum = new Sum();
        NewSum nSum = new NewSum();
        int res = calc.calcAction(div, 1, 2);
        System.out.println(res);
    }
}