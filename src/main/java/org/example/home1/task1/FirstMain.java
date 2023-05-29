package org.example.home1.task1;

import org.example.home1.task1.data.Cat;
import org.example.home1.task1.data.Owner;

public class FirstMain {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Kitten");
        cat.setAge(5);
        cat.setOwner(new Owner("Human"));
        cat.greet();
    }

}
