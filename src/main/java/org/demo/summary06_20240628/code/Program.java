package org.demo.summary06_20240628.code;

public class Program {
    public static void main(String[] args) {
        // int result = calc(12, 34, new Sum());
        int result = calc(12, 34, (x, y) -> x + y);
        System.out.println(result);
        // result = calc(12, 34, new Sub());
        result = calc(12, 34, (x, y) -> x - y);
        System.out.println(result);

        result = calc(12, 34, new BinaryOp() {
            @Override
            public int action(int x, int y) {
                return x * y;
            }
        });

        System.out.println(result);

        result = calc(12, 34, (a, b) -> a - b);
        result = calc(12, 34, Program::act);

        System.out.println(result);

    }

    static int calc(int a, int b, BinaryOp op) {
        return op.action(a, b);
    }

    static int act(int t, int u) {
        return t + u * 2;
    }
}

@FunctionalInterface
interface BinaryOp {
    int action(int x, int y);
}

// class Sum implements BinaryOp {
// @Override
// public int action(int x, int y) {
// return x + y;
// }
// }

// class Sub implements BinaryOp {
// @Override
// public int action(int x, int y) {
// return x - y;
// }
// }
