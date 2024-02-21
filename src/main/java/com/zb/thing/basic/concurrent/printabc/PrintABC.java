package com.zb.thing.basic.concurrent.printabc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PrintABC extends Thread {
    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 10;
    private static CountDownLatch cdl = new CountDownLatch(3);

    private Condition cur;
    private Condition next;
    private char ch;

    public PrintABC(Condition cur, Condition next, char ch) {
        this.cur = cur;
        this.next = next;
        this.ch = ch;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 1; i <= count; ++i) {
                System.out.println(Thread.currentThread().getName());
                System.out.print(ch);
                if (ch == 'c') {
                    System.out.println();
                }
                next.signal();
                if (i < count) {
                    try {
                        cur.await();
                    } catch (Exception e) {
                        //ignore
                    }
                }
            }
        } finally {
            lock.unlock();
        }
        cdl.countDown();
    }

    public static void main(String[] args) throws Exception {
//        Condition a = lock.newCondition();
//        Condition b = lock.newCondition();
//        Condition c = lock.newCondition();
//
//        new PrintABC(a, b, 'a').start();
//        new PrintABC(b, c, 'b').start();
//        new PrintABC(c, a, 'c').start();
//
//        cdl.await();
//        System.out.println("END");


        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                log.debug(Thread.currentThread().getName() + " 开始处理任务");
                condition.await();
                log.debug(Thread.currentThread().getName() + " 结束处理任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                log.debug(Thread.currentThread().getName() + " 开始处理任务");

                Thread.sleep(2000);
                condition.signal();
                log.debug(Thread.currentThread().getName() + " 结束处理任务");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}