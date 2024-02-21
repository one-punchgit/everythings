package com.zb.thing.basic.concurrent.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
public class CompletableFutureTest {

    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            20,
            20,
            2000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(2),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());//自定义线程池

    public static void main(String[] args) throws Exception {
        List<CompletableFutureTest> completableFutureTests = new ArrayList<>();
        CompletableFutureTest completableFutureTest1 = new CompletableFutureTest();
        CompletableFutureTest completableFutureTest2 = new CompletableFutureTest();
        CompletableFutureTest completableFutureTest3 = new CompletableFutureTest();
        completableFutureTests.add(completableFutureTest1);
        completableFutureTests.add(completableFutureTest2);
        completableFutureTests.add(completableFutureTest3);

        long cur = System.currentTimeMillis();
//        List<String> collect1 = completableFutureTests.parallelStream().map(x -> x.invoke4()).collect(Collectors.toList());
//        List<String> collect1 = completableFutureTests.stream().map(x -> x.invoke4()).collect(Collectors.toList());
        List<CompletableFuture<String>> collect = completableFutureTests.parallelStream().map(x -> CompletableFuture.supplyAsync(() -> x.invoke4(), threadPoolExecutor).exceptionally(throwable -> {
            throwable.printStackTrace();
            return "cache";
        })).collect(Collectors.toList());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[0]));
        voidCompletableFuture.get();
        log.info("get over");
        for (CompletableFuture<String> stringCompletableFuture : collect) {
            System.out.println(stringCompletableFuture.get());
        }

        System.out.println(System.currentTimeMillis() - cur);


        //获取系统线程数   逻辑核数-16，如果本机核数大约2 CompletableFuture使用ForkJoinPool
        System.out.println(Runtime.getRuntime().availableProcessors());
        //单个任务
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::invoke1);
//        completableFuture.thenAccept(s -> log.info("invoke 1 result : {}", s));
//        String s = completableFuture.get();//如果没有get阻塞 则没有结果
//
//        ArrayList<Supplier<String>> suppliers = new ArrayList<>();
//        //添加任务
//        addTask(suppliers);
//        log.info("start task");
//        //注意 stream parallelStream 的区别
//        List<CompletableFuture<String>> collect = suppliers.parallelStream()
//                .map(x -> CompletableFuture.supplyAsync(x,threadPoolExecutor).thenApply(u -> u + "-over").exceptionally(throwable -> "err"))
//                .collect(Collectors.toList());
        //anyof
//        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(collect.toArray(new CompletableFuture[0]));
//        String o = (String)objectCompletableFuture.get();
//        log.info("anyof get {}",o);

        //allof
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[0]));
//        voidCompletableFuture.get();
//        log.info("get over");
//        CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[0])).thenApply(v -> collect.parallelStream().map(x ->
//        {
//            try {
//                return x.get();
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "err";
//            }
//        }).collect(Collectors.toList()));
//        listCompletableFuture.get().sort(String::compareTo);
//        for (String s : listCompletableFuture.get()) {
//            log.info(s);
//        }
//        log.info("main over");


//        List<CompletableFuture<Runnable>> collect = threads.parallelStream().map(x -> CompletableFuture.supplyAsync()).collect(Collectors.toList());
//
//        for (CompletableFuture<Runnable> runnableCompletableFuture : collect) {
//            runnableCompletableFuture.get();
//        }

//        CompletableFuture<Double> doubleCompletableFuture = CompletableFuture.supplyAsync(() -> CompletableFutureTest.fetchPrice());
//        doubleCompletableFuture.thenAccept(x -> System.out.println("price:" + x));
//
//        doubleCompletableFuture.exceptionally(throwable -> {
//            throwable.printStackTrace();
//            return null;
//        });
//        doubleCompletableFuture.join();
//        log.info("main over");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private static void addTask(ArrayList<Supplier<String>> suppliers) {
        suppliers.add(CompletableFutureTest::invoke1);
        suppliers.add(CompletableFutureTest::invoke2);
        suppliers.add(CompletableFutureTest::invoke3);
        suppliers.add(CompletableFutureTest::invoke1);
        suppliers.add(CompletableFutureTest::invoke2);
        suppliers.add(CompletableFutureTest::invoke3);
        suppliers.add(CompletableFutureTest::invoke1);
        suppliers.add(CompletableFutureTest::invoke2);
        suppliers.add(CompletableFutureTest::invoke3);
        suppliers.add(CompletableFutureTest::invoke1);
        suppliers.add(CompletableFutureTest::invoke2);
        suppliers.add(CompletableFutureTest::invoke3);
        suppliers.add(CompletableFutureTest::invoke1);
        suppliers.add(CompletableFutureTest::invoke2);
        suppliers.add(CompletableFutureTest::invoke3);
        suppliers.add(CompletableFutureTest::invoke1);
        suppliers.add(CompletableFutureTest::invoke2);
        suppliers.add(CompletableFutureTest::invoke3);
    }


    static Double fetchPrice() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }

     String invoke4() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("thread:{}", Thread.currentThread().getName());

//        int i = 0 / 0;
        return "invoke4 result,time 4000 millis";
    }



    static String invoke1() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("thread:{}", Thread.currentThread().getName());

//        int i = 0 / 0;
        return "invoke1 result,time 4000 millis";
    }

    static String invoke2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("thread:{}", Thread.currentThread().getName());
        return "invoke2 result,time 5000 millis";
    }

    static String invoke3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("thread:{}", Thread.currentThread().getName());

        return "invoke3 result,time 3000 millis";
    }


//    static class MyThread extends Thread{
//        @Override
//        public void run() {
//
//
//        }
//    }
}
