package org.demo.summary02_20240531.code;

public class Calc {
    Logger logger = new Logger();

    public int calcAction(Operation op, int x, int y) {
        int result = op.action(x, y);
        logger.information(String.format("(%d %d) => %d", x, y, result));
        return result;
    }
}