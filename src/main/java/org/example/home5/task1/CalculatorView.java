package org.example.home5.task1;

import java.util.Scanner;

public class CalculatorView {

    private final Scanner scanner;

    public CalculatorView() {
        this.scanner = new Scanner(System.in);
    }

    public double getInputNumber() {
        System.out.print("Enter a number: ");
        return scanner.nextDouble();
    }

    public char getInputOperator() {
        System.out.print("Enter an operator (+, -, *, /): ");
        return scanner.next().charAt(0);
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }

}
