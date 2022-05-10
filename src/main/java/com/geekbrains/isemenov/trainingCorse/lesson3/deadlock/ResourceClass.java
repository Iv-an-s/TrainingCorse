package com.geekbrains.isemenov.trainingCorse.lesson3.deadlock;

public class ResourceClass {
    Object obj1 = new Object();
    Object obj2 = new Object();

    public void deadlock(){
        synchronized (obj1){
            System.out.println(String.format("Поток %s получает монитор на obj1", Thread.currentThread().getName()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("Поток %s пытается получить монитор на obj2", Thread.currentThread().getName()));
            synchronized (obj2){
                System.out.println(String.format("Поток %s получил монитор на obj2", Thread.currentThread().getName()));
            }
        }
    }

    public void deadlock2(){
        synchronized (obj2){
            System.out.println(String.format("Поток %s получает монитор на obj2", Thread.currentThread().getName()));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("Поток %s пытается получить монитор на obj1", Thread.currentThread().getName()));
            synchronized (obj1){
                System.out.println(String.format("Поток %s получил монитор на obj1", Thread.currentThread().getName()));
            }
        }
    }
}
