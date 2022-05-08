package com.geekbrains.isemenov.trainingCorse.lesson3.ThreadSafeCounter;

public class Counter {
    private long counter = 0L;

    public synchronized void increaseCounter(){
        counter++;
    }

    public long getCounter() {
        return counter;
    }
}
