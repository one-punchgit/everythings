package com.zb.thing.basic.concurrent.printabc;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

public class SyncPrintABC {
    private volatile static int i = 0;
    private static Object object = new Object();

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        countDownLatch.countDown();
//        countDownLatch.await();
        new Thread(() -> {
            while (i <= 30) {
                synchronized (object) {
                    while (i % 3 != 0) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (i > 30) {
                            break;
                        }
                    }
                    if (i <= 30) {
                        System.out.print("A");
                        i++;
                    }
                    object.notifyAll();
                }
            }

        }, "thread-a").start();


        new Thread(() -> {
            while (i <= 30) {
                synchronized (object) {
                    while (i % 3 != 1) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (i > 30) {
                            break;
                        }
                    }
                    if (i <= 30) {
                        System.out.print("B");
                        i++;
                    }
                    object.notifyAll();
                }
            }
        }, "thread-b").start();

        new Thread(() -> {
            while (i <= 30) {
                synchronized (object) {
                    while (i % 3 != 2) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (i > 30) {
                            break;
                        }
                    }
                    if (i <= 30) {
                        System.out.println("C");
                        i++;
                    }
                    object.notifyAll();
                }
            }
        }, "thread-c").start();
    }
}
