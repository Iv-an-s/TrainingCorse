package com.geekbrains.isemenov.trainingCorse.lesson1.task3;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();

        list.add(new Square(3));
        list.add(new Circle(4));
        list.add(new EquilateralTriangle(5));

        for (Shape shape : list) {
            System.out.println("Square of " + shape.getShapeName() + " is: " + shape.calculateArea());
        }

        List<Drawable> drawableList = new ArrayList<>();

        drawableList.add(new Square(3));
        drawableList.add(new Circle(4));
        drawableList.add(new EquilateralTriangle(5));

        for (Drawable drawable : drawableList) {
            drawable.draw();
        }
    }
}
