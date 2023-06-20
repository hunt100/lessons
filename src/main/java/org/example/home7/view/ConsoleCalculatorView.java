package org.example.home7.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class ConsoleCalculatorView implements CalculatorView {

    private static final Logger log = LoggerFactory.getLogger(ConsoleCalculatorView.class);

    private final Scanner scanner;

    public ConsoleCalculatorView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String inputValue() {
        String value = scanner.nextLine();
        log.debug("Scan next value from console: [{}]", value);
        return value;
    }

    @Override
    public void displayHistory(List<String> historyRecords) {
        log.debug("Show history to user: ");
        for (int i = 0; i < historyRecords.size(); i++) {
            System.out.println((i + 1) + ": " + historyRecords.get(i));
        }
        System.out.println();
    }

    @Override
    public void showResult(String result) {
        log.debug("Printing the result [{}]", result);
        System.out.println(result);
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
