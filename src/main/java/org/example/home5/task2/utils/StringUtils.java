package org.example.home5.task2.utils;

public final class StringUtils {

    private StringUtils() {}

    public static String buildRepeatedSymbolAsString(char ch, int times) {
        return String.valueOf(ch).repeat(Math.max(0, times));
    }
}
