package org.example.home7.view;

import java.util.List;

public interface CalculatorView {

    String inputValue();

    void displayHistory(List<String> historyRecords);

    void showResult(String result);

    void showMessage(String msg);

}
