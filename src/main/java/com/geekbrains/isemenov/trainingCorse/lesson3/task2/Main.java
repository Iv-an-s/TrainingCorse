package com.geekbrains.isemenov.trainingCorse.lesson3.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Counter counter = new Counter();

        for (int i = 0; i < 200; i++) {
            CounterThread counterThread = new CounterThread(lock, counter);
            counterThread.start();
        }

        Thread.sleep(1000);

        System.out.println("Count is: " + counter.getCounter());
    }
}
