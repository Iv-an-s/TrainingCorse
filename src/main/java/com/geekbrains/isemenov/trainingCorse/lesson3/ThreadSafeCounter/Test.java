package com.geekbrains.isemenov.trainingCorse.lesson3.ThreadSafeCounter;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 200; i++) {
            CounterThread counterThread = new CounterThread(counter);
            counterThread.start();
        }
        Thread.sleep(1000);

        System.out.println("Counter: " + counter.getCounter());
    }
}
