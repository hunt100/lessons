package org.example.home5.task1;

public class CalculatorModel {

    private double result;

    public void add(double number) {
        result += number;
    }

    public void subtract(double number) {
        result -= number;
    }

    public void multiply(double number) {
        result *= number;
    }

    public void divide(double number) {
        if (number != 0) {
            result /= number;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

}
