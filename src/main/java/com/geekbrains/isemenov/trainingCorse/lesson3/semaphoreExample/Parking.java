package com.geekbrains.isemenov.trainingCorse.lesson3.semaphoreExample;

import java.util.concurrent.Semaphore;

public class Parking {
    private static final boolean[] PARKING_PLACE = new boolean[5];

    private static final Semaphore SEMAPHORE = new Semaphore(5, true);

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            new Thread(new Car(i)).start();
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.println("Car #" + carNumber + " has come to parking");
            try {
                SEMAPHORE.acquire();
                int parkingNumber = -1;

                synchronized (PARKING_PLACE) {
                    for (int i = 0; i < 5; i++) {
                        if (!PARKING_PLACE[i]) {
                            PARKING_PLACE[i] = true;
                            parkingNumber = i;
                            System.out.println("Car #" + carNumber + " has parked on a parking place #" + parkingNumber);
                            break;
                        }
                    }
                }
                Thread.sleep(5000);
                synchronized (PARKING_PLACE) {
                    PARKING_PLACE[parkingNumber] = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SEMAPHORE.release();
                System.out.println("Car #" + carNumber + " left");
            }
        }
    }
}

