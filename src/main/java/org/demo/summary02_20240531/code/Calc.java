package org.demo.summary02_20240531.code;

public class Calc {
    Logger consoleLogger;

    public Calc(Logger consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    public int calcAction(Operation op, int x, int y) {
        int result = op.action(x, y);
        consoleLogger.information(String.format("(%d %d) => %d", x, y, result));
        return result;
    }
}