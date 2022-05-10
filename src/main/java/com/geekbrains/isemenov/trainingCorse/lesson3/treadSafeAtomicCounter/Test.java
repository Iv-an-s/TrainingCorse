package com.geekbrains.isemenov.trainingCorse.lesson3.treadSafeAtomicCounter;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        counter.increase();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.counter.get());
    }
}
