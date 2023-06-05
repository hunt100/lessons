package org.example.home1.task2.data;

import org.example.home1.task2.FigureArea;

public class Rectangle implements FigureArea {

    private double width;
    private double height;

    public Rectangle() {
        width = 0;
        height = 0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //region getters/setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    //endregion

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public int getEdges() {
        return 4;
    }
}
