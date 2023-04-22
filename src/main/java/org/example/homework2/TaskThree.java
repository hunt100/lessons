package org.example.homework2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TaskThree {

    private static final Logger log = LoggerFactory.getLogger(TaskThree.class);
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createSimpleCalculator();
    }

    public static void createSimpleCalculator() {
        System.out.println("Input first number: ");
        double first = sc.nextDouble();
        log.debug("Input first value: {}", first);
        System.out.println("Input operator: ");
        String operator = sc.next();
        log.debug("Input second value: {}", operator);
        System.out.println("Input second number: ");
        double second = sc.nextDouble();
        log.debug("Input third value: {}", second);

        try {
            MathOperator operation = MathOperator.getOperator(operator);
            switch (operation) {
                case ADDITION ->log.info("Result: {}", (first + second));
                case SUBTRACTION ->log.info("Result: {}", (first - second));
                case MULTIPLICATION ->log.info("Result: {}", (first * second));
                case DIVISION ->log.info("Result: {}", (first / second));
            }
        } catch (Exception e) {
            log.error("Unexpected error occurred!", e);
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
