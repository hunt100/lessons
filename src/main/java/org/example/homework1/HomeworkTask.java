package org.example.homework1;

import java.util.Scanner;

public class HomeworkTask {
    private static final Scanner sc = new Scanner(System.in);

    /*
     *  1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
     *  2. Вывести все простые числа от 1 до 1000
     *  3. Реализовать простой калькулятор
        Введите первое число: 12
        Введите операцию: +
        Введите второе число: 1
        Ответ: 13
     */
    public static void main(String[] args) {
        calculateSumAndMulti();     // task 1
        findPrimeNumbers();         // task 2
        createSimpleCalculator();   // task 3
    }

    public static void calculateSumAndMulti() {
        System.out.println("Insert n: ");
        int n = sc.nextInt();
        int sum = 0;
        int multiplication = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            multiplication *= i;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Multi: " + multiplication);
    }

    public static void findPrimeNumbers() {
        for (int i = 2; i < 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("Prime number: " + i);
            }
        }
    }

    public static void createSimpleCalculator() {
        System.out.println("Input first number: ");
        double first = sc.nextDouble();
        System.out.println("Input operator: ");
        String operator = sc.next();
        System.out.println("Input second number: ");
        double second = sc.nextDouble();

        try {
            MathOperator operation = MathOperator.getOperator(operator);
            switch (operation) {
                case ADDITION -> System.out.printf("Result: %,.2f", (first + second));
                case SUBTRACTION -> System.out.printf("Result: %,.2f", (first - second));
                case MULTIPLICATION -> System.out.printf("Result: %,.2f", (first * second));
                case DIVISION -> System.out.printf("Result: %,.2f", (first / second));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
