package com.geekbrains.isemenov.trainingCorse.lesson3.task2;

import java.util.concurrent.locks.Lock;

public class CounterThread extends Thread {
    private final Lock lock;
    private final Counter counter;

    public CounterThread(Lock lock, Counter counter) {
        this.lock = lock;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                lock.lock();
                counter.increaseCounter();
            } finally {
                lock.unlock();
            }
        }
    }
}
