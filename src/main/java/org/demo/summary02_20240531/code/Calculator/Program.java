package org.demo.summary02_20240531.code.Calculator;

import org.demo.summary02_20240531.code.Calculator.core.Calc;
import org.demo.summary02_20240531.code.Calculator.logger.ConsoleLogger;
import org.demo.summary02_20240531.code.Calculator.logger.FileLogger;
import org.demo.summary02_20240531.code.Calculator.operation.Div;
import org.demo.summary02_20240531.code.Calculator.operation.NewSum;
import org.demo.summary02_20240531.code.Calculator.operation.Sum;

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