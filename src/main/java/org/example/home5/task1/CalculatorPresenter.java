package org.example.home5.task1;

public class CalculatorPresenter {

    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorPresenter(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void performCalculation() {
        try {
            double firstNumber = view.getInputNumber();
            char operator = view.getInputOperator();
            double secondNumber = view.getInputNumber();

            model.setResult(firstNumber);
            switch (operator) {
                case '+' -> model.add(secondNumber);
                case '-' -> model.subtract(secondNumber);
                case '*' -> model.multiply(secondNumber);
                case '/' -> model.divide(secondNumber);
                default -> throw new IllegalArgumentException("Invalid operator");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        view.displayResult(model.getResult());
    }

}
