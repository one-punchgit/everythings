package com.zb.thing.basic.concurrent.reentrantlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

public class ReentrantLockTest {
    private final Lock reentrantLock = new ReentrantLock();
    private final Condition condition = reentrantLock.newCondition();
    private final Queue<String> queue = new LinkedList<>();

    //只允许一个线程写入（其他线程既不能写入也不能读取 没有写入时，多个线程允许同时读（提高性能）
    // 如果有线程正在读，写线程需要等待读线程释放锁后才能获取写锁，即读的过程中不允许写，这是一种悲观的读锁
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();


    // 任意时刻仅允许最多3个线程获取许可:
    final Semaphore semaphore = new Semaphore(3);


    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread addThread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLockTest.addTask(Thread.currentThread().getName() + "-" + i);
            }
        }, "addThread1");
        Thread addThread2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLockTest.addTask(Thread.currentThread().getName() + "-" + i);
            }
        }, "addThread2");

        addThread1.start();
        addThread2.start();
        Thread getThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                String task = reentrantLockTest.getTask();
                System.out.println("get task:" + task);
            }
        }, "getThread");

        getThread.start();

        try {
            addThread1.join();
            addThread2.join();
            getThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main over");

    }


    private void access() {
        try {
            semaphore.acquire();// 如果超过了许可数量,其他线程将在此等待:
            System.out.println("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }


    }

    private void addTask(String s) {
        reentrantLock.lock();
        try {
            queue.add(s);
            System.out.println("add task:" + s);
            condition.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    private String getTask() {
        reentrantLock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        } finally {
            reentrantLock.unlock();
        }
    }
}
