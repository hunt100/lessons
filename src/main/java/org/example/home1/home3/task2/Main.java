package org.example.home1.home3.task2;

import org.example.home1.task1.data.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        Cat c = new Cat("C1", 12);
        Cat c2 = new Cat("C2", 100);
        Cat c3 = new Cat("C3", 50);
        Cat c4 = new Cat("C4", 30);
        Cat c5 = new Cat("C5", 1);
        cats.add(c);
        cats.add(c2);
        cats.add(c3);
        cats.add(c4);
        cats.add(c5);

        Collections.sort(cats);
        System.out.println(cats);
    }

}
