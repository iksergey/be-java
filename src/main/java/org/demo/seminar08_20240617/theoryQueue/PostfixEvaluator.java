package org.demo.seminar08_20240617.theoryQueue;

import java.util.Stack;

// TODO: Программа почти работает. Нужно доделать
public class PostfixEvaluator {

    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result = applyOperator(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String expression = "10 2 + 3 * 4 *"; // Пример: (10 + 2) * 3 * 4
        int result = evaluate(expression);
        System.out.println("Результат: " + result);
    }
}
