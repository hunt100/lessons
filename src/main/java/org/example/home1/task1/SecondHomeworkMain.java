package org.example.home1.task1;

import org.example.home1.task1.data.Animal;
import org.example.home1.task1.data.Cat;
import org.example.home1.task1.data.Lion;

import java.util.List;

public class SecondHomeworkMain {

    public static void main(String[] args) {
        List<Animal> animals = new CustomList<>();

        var lion1 = new Lion();
        lion1.setName("Lion1");
        lion1.startHunt();

        var lion2 = new Lion();
        lion2.setName("Lion2");
        lion2.startHunt();

        var cat1 = new Cat();
        cat1.setName("Cat1");

        var cat2 = new Cat();
        cat2.setName("Cat2");

        animals.add(lion1);
        animals.add(lion2);
        animals.add(cat1);
        animals.add(cat2);

        System.out.println(animals);
    }
}
