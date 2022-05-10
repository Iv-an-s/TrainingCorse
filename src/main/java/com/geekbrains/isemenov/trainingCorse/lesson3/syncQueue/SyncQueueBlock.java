package com.geekbrains.isemenov.trainingCorse.lesson3.syncQueue;

public class SyncQueueBlock {
    private final LockObject lock = new LockObject();
    Object object;

    public int get() throws InterruptedException {
        synchronized (lock) {
            while (!lock.isFlag()) {
                lock.wait();
            }
            Thread.sleep(500);
            System.out.println("Объект " + lock.getN() + " получен");
            lock.setFlag(false);
            lock.notify();
            return lock.getN();
        }
    }

    void put(int n) throws InterruptedException {
        synchronized (lock) {
            while (lock.isFlag()) {
                lock.wait();
            }
            Thread.sleep(500);
            lock.setN(n);
            System.out.println("Объект " + n + " доставлен");
            lock.setFlag(true);
            lock.notify();
        }
    }
}
