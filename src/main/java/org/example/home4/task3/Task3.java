package org.example.home4.task3;

public class Task3 {

    public static void main(String[] args) {
        System.out.println(getMax(12, 23));
        System.out.println(getMax(1.1, 3.6));
        System.out.println(getMax("loki", "thor"));
    }

    public static <T extends Comparable<T>> T getMax(T first, T second) {
        return first.compareTo(second) >= 0 ? first : second;
    }

}
