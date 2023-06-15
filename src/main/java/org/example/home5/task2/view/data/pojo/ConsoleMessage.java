package org.example.home5.task2.view.data.pojo;

import org.example.home5.task2.utils.StringUtils;
import org.example.home5.task2.view.data.enums.FormType;

public abstract class ConsoleMessage {

    private static final int HEADER_LENGTH = 20;
    private static final char ASTERISK_SYMBOL = '*';
    private static final char CORNER_SYMBOL = '|';

    public abstract FormType getFormType();

    public void printMessage() {
        var builder = new StringBuilder();
        String lineSeparator = "line.separator";
        System.out.println(
                builder.append(CORNER_SYMBOL)
                        .append(StringUtils.buildRepeatedSymbolAsString(ASTERISK_SYMBOL, getHalfPartSizeWithoutType()))
                        .append(getFormType().name())
                        .append(StringUtils.buildRepeatedSymbolAsString(ASTERISK_SYMBOL, getHalfPartSizeWithoutType()))
                        .append(CORNER_SYMBOL)
                        .append(System.getProperty(lineSeparator))
                        .append(getCustomText())
                        .append(System.getProperty(lineSeparator)));

    }

    private int getHalfPartSizeWithoutType() {
        int length = getFormType().name().length();
        return HEADER_LENGTH - length / 2;
    }

    public abstract String getCustomText();

    public void printErrorMessage() {
        System.out.println("| Error appeared. Retry later |");
    }

}
