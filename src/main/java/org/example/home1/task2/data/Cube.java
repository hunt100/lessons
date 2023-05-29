package org.example.home1.task2.data;

import org.example.home1.task2.FigureVolume;

public class Cube implements FigureVolume {

    private final double length;

    public Cube(double length) {
        this.length = length;
    }

    @Override
    public double getVolume() {
        return Math.pow(length, 3);
    }

    @Override
    public int getEdges() {
        return 12;
    }

}
