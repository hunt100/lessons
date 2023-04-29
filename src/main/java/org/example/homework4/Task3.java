package org.example.homework4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task3 {
    /*
    3) В калькулятор добавьте возможность отменить последнюю операцию.
    Пример

    1
    +
    2
    ответ:
    3

    +
    4
    ответ:
    7
    +
    2

    ответ:

    9
    1
    Ответ 8
    Отмена -> 9
    Отмена -> 7
    Отмена -> 3
    +
    2
    Ответ 5
     */

    private static final String CANCELLATION = "C";
    private static final String STOP = "stop";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startCalculator();
    }

    public static void startCalculator() {
        boolean firstInput = true;
        Deque<Double> resultDeque = new ArrayDeque<>();
        while (true) {
            double first;
            String operator;
            double second;
            if (firstInput) {
                System.out.println("Input first number: ");
                first = sc.nextDouble();
                System.out.println("Input operator: ");
                operator = sc.next();
                if (operator.equals(STOP)) {
                    break;
                }
                System.out.println("Input second number: ");
                second = sc.nextDouble();
                firstInput = false;
            } else {
                if (resultDeque.isEmpty()) {
                    System.out.println("No elements in dequeue, restart process");
                    firstInput = true;
                    continue;
                }
                first = resultDeque.getLast();
                System.out.println("Input operator: ");
                operator = sc.next();
                if (operator.equals(CANCELLATION)) {
                    System.out.println("Cancellation -> " + resultDeque.pollLast());
                    continue;
                }
                if (operator.equals(STOP)) {
                    break;
                }
                System.out.println("Input second number: ");
                second = sc.nextDouble();
            }

            double result = compute(first, second, operator);
            System.out.println("Answer: " + result);
            resultDeque.add(result);

        }
    }

    public static double compute(double first ,double second, String operator) {
        try {
            MathOperator operation = MathOperator.getOperator(operator);
            return switch (operation) {
                case ADDITION -> first + second;
                case SUBTRACTION -> first - second;
                case MULTIPLICATION -> first * second;
                case DIVISION -> first / second;
            };
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public enum MathOperator {
        ADDITION("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        private final String operator;

        MathOperator(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }

        public static MathOperator getOperator(String op) {
            for (MathOperator currentOp : values()) {
                if (currentOp.getOperator().equals(op)) {
                    return currentOp;
                }
            }
            throw new IllegalArgumentException("Unexpected operation " + op);
        }
    }
}
