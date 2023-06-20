package org.example.home7.presenter;

import org.example.home7.model.calculation.Calculation;
import org.example.home7.model.calculation.CalculationResult;
import org.example.home7.model.calculation.Operator;
import org.example.home7.model.history.HistoryService;
import org.example.home7.structural.Constants;
import org.example.home7.view.CalculatorView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleCalculatorPresenter implements CalculationPresenter {

    private static final Logger log = LoggerFactory.getLogger(SimpleCalculatorPresenter.class);
    private final CalculatorView calculatorView;
    private final HistoryService historyService;

    public SimpleCalculatorPresenter(CalculatorView calculatorView, HistoryService historyService) {
        this.calculatorView = calculatorView;
        this.historyService = historyService;
    }

    @Override
    public void start() {
        while (true) {
            try {
                calculatorView.showMessage(Constants.Message.WELCOME);
                String op = calculatorView.inputValue();
                if (op.equals(Constants.Commands.EXIT_CMD)) {
                    log.info("Program stopped!");
                    break;
                }
                if (op.equals(Constants.Commands.HISTORY_CMD)) {
                    calculatorView.displayHistory(historyService.getHistory());
                    continue;
                }
                Operator operator = Operator.getOpBySymbol(op);
                calculatorView.showMessage(Constants.Message.FIRST_OPERAND);
                String firstNumber = calculatorView.inputValue();
                calculatorView.showMessage(Constants.Message.SECOND_OPERAND);
                String secondNumber = calculatorView.inputValue();
                Calculation result = new CalculationResult(firstNumber, secondNumber, operator);
                calculatorView.showMessage(Constants.Message.RESULT_MESSAGE);
                calculatorView.showResult(result.getResult());
                historyService.addHistoryRecord(result.toString());
            } catch (Exception e) {
                log.error("Error appeared!", e);
            }
        }
    }

}
