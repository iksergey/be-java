package org.demo.summary02_20240531.code.Calculator.core;

import org.demo.summary02_20240531.code.Calculator.logger.Logger;
import org.demo.summary02_20240531.code.Calculator.operation.Operation;

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