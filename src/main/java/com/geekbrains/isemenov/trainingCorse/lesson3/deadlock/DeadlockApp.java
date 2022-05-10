package com.geekbrains.isemenov.trainingCorse.lesson3.deadlock;

public class DeadlockApp {
    public static void main(String[] args) {
        ResourceClass resource = new ResourceClass();

        new Thread(new Runnable() {
            @Override
            public void run() {
                resource.deadlock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                resource.deadlock2();
            }
        }).start();
    }
}
