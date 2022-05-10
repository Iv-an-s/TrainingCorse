package com.geekbrains.isemenov.trainingCorse.lesson3.syncQueue;

public class Producer implements Runnable {
    SyncQueueBlock syncQueue;

    public Producer(SyncQueueBlock syncQueue) {
        this.syncQueue = syncQueue;
        new Thread(this, "Отправитель").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            try {
                syncQueue.put(i++);
                Thread.State state = Thread.currentThread().getState();
                System.out.println(String.format("Thread state is %s", state));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
