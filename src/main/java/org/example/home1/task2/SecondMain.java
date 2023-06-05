package org.example.home1.task2;

import org.example.home1.task2.data.Cube;
import org.example.home1.task2.data.Rectangle;

public class SecondMain {

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        System.out.println("Area: " + r.getArea());
        System.out.println("Per: " + r.calculatePerimeter());

        Rectangle r2 = new Rectangle(10, 5);
        System.out.println("Area: " + r2.getArea());
        System.out.println("Per: " + r2.calculatePerimeter());

        Rectangle rectangle = new Rectangle(12, 12);
        System.out.println("Rectangle: " + rectangle.getArea());
        printEdges(rectangle);

        Cube cube = new Cube(3);
        System.out.println("Cube: " + cube.getVolume());
        printEdges(cube);
    }

    private static void printEdges(FigureEdge figure) {
        System.out.println("Edges in figure: " + figure.getEdges());
    }

}
