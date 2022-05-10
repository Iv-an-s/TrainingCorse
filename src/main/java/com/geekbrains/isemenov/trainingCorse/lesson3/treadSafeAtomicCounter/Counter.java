package com.geekbrains.isemenov.trainingCorse.lesson3.treadSafeAtomicCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger counter;

    public Counter() {
        counter = new AtomicInteger();
    }

    void increase(){
        counter.incrementAndGet();
    }
}
