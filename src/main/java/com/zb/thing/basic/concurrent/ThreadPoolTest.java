package com.zb.thing.basic.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ThreadPoolTest {
    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,
            2,
            2000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());
    //CallerRunsPolicy main方法执行此次任务
    //AbortPolicy 拒绝执行 抛出异常(后面任务都不会执行了)
    //DiscardPolicy 自动丢弃 什么也不干
    //DiscardOldestPolicy 弹出队列首 执行新任务

    private static AtomicInteger num = new AtomicInteger(0);


    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 60; i++) {
            threadPoolExecutor.execute(() -> {
                log.info("thread:{},num-{}",Thread.currentThread().getName(),num.incrementAndGet());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(14000);
        log.info("queue size {}",threadPoolExecutor.getQueue().size());
        System.out.println(threadPoolExecutor);




//
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(1);
//
//        //以固定时间间隔2s执行 如果任务时间是3s 则每3s执行; 如果有异常 则卡住
//        executorService1.scheduleAtFixedRate(() -> {
//            log.info("fix rate" + num++);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (num == 5) {
//                throw new RuntimeException("err");
//            }
//        }, 2, 2, TimeUnit.SECONDS);
//
//        //以任务执行完后2s后执行 如果有异常 则卡住
//        executorService1.scheduleWithFixedDelay(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.info("fix delay" + num++);
//            if (num == 5) {
//                throw new RuntimeException("err");
//            }
//        }, 2, 2, TimeUnit.SECONDS);
    }



}
