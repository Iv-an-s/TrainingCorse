package com.geekbrains.isemenov.trainingCorse.lesson1.task3;

public class Square extends Shape implements Drawable {
    public Square(int side) {
        super(side);
        this.shapeName = "Square";
    }

    @Override
    double calculateArea() {
        return dimension * dimension;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}
