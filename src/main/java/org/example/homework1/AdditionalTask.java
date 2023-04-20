package org.example.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdditionalTask {

    /*
     *  Дополнительно: +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
     *  например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить,
     *  что его нет. Под знаками вопросов - одна и та же цифра Ввод: 2? + ?5 = 69 Вывод: 24 + 45 = 69
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write expression: q + w = e");
        String expression = sc.nextLine();
        List<String> arguments = getArguments(Arrays.asList(expression.split(" ")));
        tryToFindSolutions(arguments);

    }

    public static void tryToFindSolutions(List<String> arguments) {
        String qArg = arguments.get(0);
        String wArg = arguments.get(1);
        String eArg = arguments.get(2);

        boolean isQArgWithQuestion = containsQuestionMark(qArg);
        boolean isWArgWithQuestion = containsQuestionMark(wArg);
        boolean isEArgWithQuestion = containsQuestionMark(eArg);

        if (!isQArgWithQuestion && !isWArgWithQuestion && !isEArgWithQuestion) {
            if (Integer.parseInt(qArg) + Integer.parseInt(wArg) == Integer.parseInt(eArg)) {
                System.out.println("Current expression is true: " + qArg + " + " + wArg + " = " + eArg);
            } else {
                System.out.println("Expression is wrong!");
            }
            return;
        }

        boolean noSolutions = true;
        for (int i = 0; i <= 9; i++) {
            int q,w,e;
            q = getArgAsInt(qArg, isQArgWithQuestion, i);
            w = getArgAsInt(wArg, isWArgWithQuestion, i);
            e = getArgAsInt(eArg, isEArgWithQuestion, i);

            if (q + w == e) {
                noSolutions = false;
                System.out.println("One solution is: " + q + " + " +  w + " = " + e);
            }
        }

        if (noSolutions) {
            System.out.println("There is no solutions!");
        }
    }

    public static int getArgAsInt(String arg, boolean isArgWithQuestion, int currentIteration) {
        if (isArgWithQuestion) {
            return Integer.parseInt(arg.replace("?", String.valueOf(currentIteration)));
        }

        return Integer.parseInt(arg);
    }

    public static boolean containsQuestionMark(String arg) {
        return arg.contains("?");
    }

    public static List<String> getArguments(List<String> parts) {
        List<String> onlyArguments = new ArrayList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (i % 2 == 0) {
                onlyArguments.add(parts.get(i));
            }
        }
        return onlyArguments;
    }

}
