package org.example.homework3;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Task2 {

    /*
        Пусть дан произвольный список целых чисел, удалить из него чётные числа
     */
    public static void main(String[] args) {
        int iteration = 20;
        Random random = new Random(12345);
        List<Integer> numbers = Stream.generate(() -> random.nextInt(0, 100))
                .limit(iteration)
                .toList();

        System.out.println("Original array:");
        System.out.println(numbers);

        List<Integer> newArr = numbers.stream()
                .filter(i -> i % 2 != 0)
                .toList();
        System.out.println("Filtered array:");
        System.out.println(newArr);
    }

}
