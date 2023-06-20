package org.example.home7.model.calculation;

public enum Operator {
    ADDITION("+"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator getOpBySymbol(String op) {
        switch (op) {
            case "+" -> {
                return ADDITION;
            }
            case "*" -> {
                return MULTIPLICATION;
            }
            case "/" -> {
                return DIVISION;
            }
        }
        throw new IllegalArgumentException("Wrong operation input " + op);
    }
}
