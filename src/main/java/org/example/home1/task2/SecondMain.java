package org.example.home1.task2;

public class SecondMain {

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        System.out.println("Area: " + r.calculateArea());
        System.out.println("Per: " + r.calculatePerimeter());

        Rectangle r2 = new Rectangle(10, 5);
        System.out.println("Area: " + r2.calculateArea());
        System.out.println("Per: " + r2.calculatePerimeter());
    }

}
