package org.example.homework5;

import java.util.*;

/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера
2) Вывод всего
 */
public class Task1 {

    private static final int ADD_NUMBER_OP = 1;
    private static final int SHOW_ALL_OP = 2;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        while (true) {
            try {
                System.out.println("Input command (1/2): ");
                int inputOp = sc.nextInt();
                if (inputOp == ADD_NUMBER_OP) {
                    inputNewNumber(phoneBook);
                } else if (inputOp == SHOW_ALL_OP) {
                    printAll(phoneBook);
                    break;
                } else {
                    throw new RuntimeException("Wrong input");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception appear, try again!");
            }
        }
    }

    private static void inputNewNumber(Map<String, List<String>> phoneBook) {
        System.out.println("Input surname:");
        String surname = sc.next();
        System.out.println("Input phone number:");
        String phoneNumber = sc.next();
        phoneBook.computeIfAbsent(surname, s -> new ArrayList<>()).add(phoneNumber);
    }

    private static void printAll(Map<String, List<String>> phoneBook) {
        phoneBook.forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
