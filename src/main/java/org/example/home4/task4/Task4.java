package org.example.home4.task4;

import java.util.Comparator;

public class Task4 {

    public static void main(String[] args) {
        DataContainer<Integer> ints = new DataContainer<>(new Integer[7]);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.print();
        System.out.println();
        System.out.println(ints.get(3));

        ints.sort(Comparator.reverseOrder());
        System.out.println(ints);

        System.out.println();
        DataContainer<String> strings = new DataContainer<>(new String[3]);
        strings.add("asd");
        strings.add("123");
        strings.add("qwe");
        System.out.println(strings);
//        strings.add("Exception!");
    }

}
