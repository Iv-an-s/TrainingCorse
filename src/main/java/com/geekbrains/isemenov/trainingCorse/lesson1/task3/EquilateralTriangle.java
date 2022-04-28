package com.geekbrains.isemenov.trainingCorse.lesson1.task3;

public class EquilateralTriangle extends Shape implements Drawable {
    public EquilateralTriangle(int side) {
        super(side);
        this.shapeName = "Equilateral Triangle";
    }

    @Override
    double calculateArea() {
        return Math.sqrt(3) * dimension * dimension / 4;
    }


    @Override
    public void draw() {
        System.out.println("Рисуем треугольник");
    }
}
