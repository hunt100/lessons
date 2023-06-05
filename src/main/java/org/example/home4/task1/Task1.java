package org.example.home4.task1;

public class Task1 {

    public static void main(String[] args) {
        printElement(-12.5);
        printElement("asd");
        printElement(new Object());
    }

    public static <T> void printElement(T element) {
        System.out.println(element);
    }

}
