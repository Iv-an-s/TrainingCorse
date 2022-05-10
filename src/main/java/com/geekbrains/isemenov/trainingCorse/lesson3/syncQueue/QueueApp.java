package com.geekbrains.isemenov.trainingCorse.lesson3.syncQueue;

public class QueueApp {
    public static void main(String[] args) {
        SyncQueueBlock syncQueueBlock = new SyncQueueBlock();
        new Producer(syncQueueBlock);
        new Consumer(syncQueueBlock);
    }
}
