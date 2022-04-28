package com.geekbrains.isemenov.trainingCorse.lesson1.task3;

public abstract class Shape {
    protected String shapeName;
    protected int dimension;

    public Shape(int dimension) {
        this.dimension = dimension;
    }

    abstract double calculateArea();

    public String getShapeName() {
        return shapeName;
    }
}
