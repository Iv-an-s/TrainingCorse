package com.geekbrains.isemenov.trainingCorse.lesson1.task2;

/**
 * 1. метод open() следует делать публичным
 */
public class LightWeightCar extends Car implements Movable {
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
