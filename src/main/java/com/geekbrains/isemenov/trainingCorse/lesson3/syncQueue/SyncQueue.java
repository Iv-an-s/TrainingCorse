package com.geekbrains.isemenov.trainingCorse.lesson3.syncQueue;

public class SyncQueue {
    int n;
    boolean flag = false;

    synchronized int get() throws InterruptedException {
        while (!flag){
            wait();
        }
        Thread.sleep(500);
        System.out.println("Объект " + n + " получен");
        flag = false;
        notify();
        return n;
    }

    synchronized void put (int n) throws InterruptedException {
        while (flag){
            wait();
        }
        Thread.sleep(500);
        this.n = n;
        System.out.println("Объект " + n + "доставлен");
        flag = true;
        notify();
    }
}
