package com.geekbrains.isemenov.trainingCorse.lesson3.threadSafeCounter;

public class Counter {
    private long counter = 0L;

    public synchronized void increaseCounter(){
        counter++;
    }

    public long getCounter() {
        return counter;
    }
}
