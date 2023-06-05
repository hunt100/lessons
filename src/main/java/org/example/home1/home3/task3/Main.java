package org.example.home1.home3.task3;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 3, 5, 9, 8, 6, 2, 4);
        List<Integer> sortedList = sort(integerList, Integer::compareTo);
        System.out.println(sortedList);

        List<String> strings = List.of("Abracadabra", "Charlie", "Delta", "Beta");
        List<String> sortedStrings = sort(strings, Comparator.reverseOrder());
        System.out.println(sortedStrings);


    }

    public static <T> List<T> sort(List<T> collection, Comparator<T> comparator) {
        return collection.stream().sorted(comparator).toList();
    }

}
