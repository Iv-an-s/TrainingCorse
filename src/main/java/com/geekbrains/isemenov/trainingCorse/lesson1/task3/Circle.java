package com.geekbrains.isemenov.trainingCorse.lesson1.task3;

public class Circle extends Shape implements Drawable {
    public Circle(int radius) {
        super(radius);
        this.shapeName = "Circle";
    }

    @Override
    double calculateArea() {
        return Math.PI * dimension * dimension / 2;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем круг");
    }
}
