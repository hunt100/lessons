package org.example.home7.model.calculation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.UUID;

public class CalculationResult implements Serializable, Calculation {

    private static final Logger log = LoggerFactory.getLogger(CalculationResult.class);

    private final String uuid;
    private String firstNumber;
    private String secondNumber;
    private Operator operation;
    private String result;

    public CalculationResult() {
        this.uuid = UUID.randomUUID().toString();
    }

    public CalculationResult(String firstNumber, String secondNumber, Operator operation) {
        this.uuid = UUID.randomUUID().toString();
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Operator getOperation() {
        return operation;
    }

    public void setOperation(Operator operation) {
        this.operation = operation;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String getResult() {
        log.info("Calculation result [{}] for first number: [{}], op: [{}], secondNumber: [{}] executed", uuid, firstNumber, operation, secondNumber);
        this.result = findResult();
        log.info("The result of calculation [{}] is [{}]", uuid, result);
        return result;
    }

    private String findResult() {
        final ComplexNumber first = new ComplexNumber(firstNumber);
        final ComplexNumber second = new ComplexNumber(secondNumber);
        return switch (operation) {
            case ADDITION -> first.plus(second).print();
            case MULTIPLICATION ->  first.multiply(second).print();
            case DIVISION ->  first.divide(second).print();
        };
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return firstNumber + " " + operation.getSymbol() + " " + secondNumber + " = " + result;
    }
}
