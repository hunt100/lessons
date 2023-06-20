package org.example.home7.structural;

import org.example.home7.model.history.HistoryService;
import org.example.home7.model.history.SimpleHistoryService;
import org.example.home7.presenter.CalculationPresenter;
import org.example.home7.presenter.SimpleCalculatorPresenter;
import org.example.home7.view.CalculatorView;
import org.example.home7.view.ConsoleCalculatorView;

import java.util.Scanner;

public final class ApplicationContext {

    private static CalculatorView calculatorView;
    private static CalculationPresenter calculationPresenter;
    private static HistoryService historyService;
    private static final Object MUTEX = new Object();

    private ApplicationContext() {
    }

    public static CalculationPresenter getPresenterInstance() {
        if(calculationPresenter == null) {
            synchronized (MUTEX) {
                calculationPresenter = new SimpleCalculatorPresenter(getCalculatorView(), getHistoryService());
            }
        }
        return calculationPresenter;
    }

    public static CalculatorView getCalculatorView() {
        if(calculatorView == null) {
            synchronized (MUTEX) {
                calculatorView = new ConsoleCalculatorView(new Scanner(System.in));
            }
        }
        return calculatorView;
    }

    public static HistoryService getHistoryService() {
        if(historyService == null) {
            synchronized (MUTEX) {
                historyService = new SimpleHistoryService();
            }
        }
        return historyService;
    }
}
