package org.example.homework3;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Task3 {
    /*
    Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     */
    public static void main(String[] args) {
        int iteration = 20;
        Random random = new Random(54321);
        List<Integer> numbers = Stream.generate(() -> random.nextInt(0, 100))
                .limit(iteration)
                .toList();

        System.out.println("Original list:");
        System.out.println(numbers);

        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(integer -> System.out.println("Min number:" + integer));

        numbers.stream()
                .max(Integer::compareTo)
                .ifPresent(integer -> System.out.println("Max number:" + integer));

        numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(value -> System.out.println("Avg of numbers: " + value));
    }

}
