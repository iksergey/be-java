package org.demo.summary02_20240531.code;

public class Program {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            run();
        }
    }

    public static void run() {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fl = new FileLogger();

        Calc calc = new Calc(consoleLogger);
        Div div = new Div();
        Sum sum = new Sum();
        NewSum nSum = new NewSum();
        int res = calc.calcAction(div, 1, 2);
        System.out.println(res);
    }
}