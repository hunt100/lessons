package org.example.home4.task2;

public class Task2 {

    public static void main(String[] args) {
        printArray(new Integer[]{1, 2, 3, 4, 5});
        printArray(new String[]{"alpha", "beta", "charlie", "delta", "epsilon"});
    }

    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }
        System.out.println();
    }
}
