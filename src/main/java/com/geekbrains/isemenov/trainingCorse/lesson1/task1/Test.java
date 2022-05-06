package com.geekbrains.isemenov.trainingCorse.lesson1.task1;

public class Test {
    public static void main(String[] args) {
        Person person = new Person.Builder("Bob", "Smith", "Male")
                .address("Moscow")
                .country("Russia")
                .age(30)
                .phone("1234567")
                .build();

        System.out.println(person);
    }
}
