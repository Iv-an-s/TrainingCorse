package com.geekbrains.isemenov.trainingCorse.lesson3.task1;

public class PingPongApp {
    static volatile boolean flag = true;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println("Ping");
                    flag = false;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (!flag) {
                    System.out.println("Pong");
                    flag = true;
                }
            }
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
