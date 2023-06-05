package org.example.home1.task2.data;

import org.example.home1.task2.FigureArea;

public record Circle(Double radius) implements FigureArea {

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public int getEdges() {
        throw new UnsupportedOperationException();
    }
}
