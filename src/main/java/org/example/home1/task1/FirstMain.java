package org.example.home1.task1;

public class FirstMain {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Kitten");
        cat.setAge(5);
        cat.setOwner(new Owner("Human"));
        cat.greet();
    }
}
