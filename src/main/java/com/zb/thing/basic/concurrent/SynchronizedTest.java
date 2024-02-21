package com.zb.thing.basic.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {
    Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        synchronized (""){

        }
        SynchronizedTest synchronizedTest = new SynchronizedTest();


        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    String task = synchronizedTest.getTask();
                    System.out.println("get task:" + task);
                }
            });
            thread.start();
        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = "t-" + Math.random();
                System.out.println("add task:" + s);
                synchronizedTest.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {//使用while 再次判断是否是空
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }
}
