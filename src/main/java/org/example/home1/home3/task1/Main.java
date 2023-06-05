package org.example.home1.home3.task1;

import org.example.home1.task2.FigureArea;
import org.example.home1.task2.data.Circle;
import org.example.home1.task2.data.Rectangle;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(3.0);
        Rectangle rectangle = new Rectangle(3.0, 4.0);

        AreaCalculator calculator = FigureArea::getArea;

        System.out.println("Rectangle area: " + calculator.calculate(rectangle));
        System.out.println("Circle area: " + calculator.calculate(circle));
    }

}
