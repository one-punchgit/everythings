package com.zb.thing.basic.jvm;

public class DeadLockTest {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1){
                System.out.println("thread1 lock 1 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("thread1 lock 2 start");
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (lock2){
                System.out.println("thread2 lock 2 start");
                synchronized (lock1){
                    System.out.println("thread2 lock 1 start");
                }
            }
        }).start();
    }
}
