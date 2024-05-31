package org.demo.summary02_20240531.code.Calculator.logger;

public class ConsoleLogger implements Logger {
    public void information(String msg) {
        System.out.println(" >>> " + msg);
    }
}

