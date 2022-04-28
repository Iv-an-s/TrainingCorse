package com.geekbrains.isemenov.trainingCorse.lesson1.task2;

/**
 * 1. т.к. метод open() у абстрактного класса Car абстрактный - обязаны его переопределить, либо сделать класс абстрактым.
 * 2. не допустима запись: class Lorry extends Car, Movable, Stopablе... Класс может имплементировать но не "экстендить" интерфейсы
 * 3. не понятна причина "непубличности" класса.
 */
class Lorry extends Car implements Movable, Stopable {
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}
