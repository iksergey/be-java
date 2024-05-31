package org.demo.summary02_20240531.code;

public class ConsoleLogger implements Logger {
    public void information(String msg) {
        System.out.println(" >>> " + msg);
    }
}

