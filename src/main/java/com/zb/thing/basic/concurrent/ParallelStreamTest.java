package com.zb.thing.basic.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(String.format("  >>>CPU:%s, parallelStream:%s",
                Runtime.getRuntime().availableProcessors(),
                ForkJoinPool.commonPool().getParallelism()));
        List<String> stringList = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) stringList.add(String.valueOf(i));
        for (int i = 0; i < 3; i++) stringList2.add(String.valueOf(i));

            stringList.parallelStream().forEach(each -> {
                System.out.println(Thread.currentThread().getName() + " run:" + each);
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        Thread.sleep(1500);

        new Thread(() -> {
            stringList2.parallelStream().forEach(each -> {
                System.out.println(Thread.currentThread().getName() + "run:" + each);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }, "thread2").start();
    }

}
