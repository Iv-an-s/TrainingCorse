package com.geekbrains.isemenov.trainingCorse.lesson3.syncQueue;

public class Consumer implements Runnable{
    SyncQueueBlock syncQueue;

    public Consumer(SyncQueueBlock syncQueue) {
        this.syncQueue = syncQueue;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true){
            try {
                syncQueue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
