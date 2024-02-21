package com.zb.thing.basic.concurrent.completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.*;

@Slf4j
public class CompletableFutureTest1 {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello";
            }
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "world";
            }
        });
        CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2);//任意一个结果return
        log.info(result.join().toString());


        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "1路车来了";
            }
        }).acceptEither(CompletableFuture.supplyAsync(new Supplier<String>() {//任意一个结果return
            @Override
            public String get() {
                return "2路车来了";
            }
        }), new Consumer<String>() {
            @Override
            public void accept(String s) {
                log.info(s);
            }
        });
        voidCompletableFuture1.join();


        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                log.debug("厨师炒菜中");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "西红柿炒鸡蛋";
            }
        }).thenCombine(CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                log.info("蒸饭中");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "蒸饭完成";
            }
        }), new BiFunction<String, String, Void>() {
            @Override
            public Void apply(String s, String s2) {//合并
                log.info(s);
                log.info(s2);
                log.info("开饭 ");
                return null;
            }
        });

//                .thenAccept(new Consumer<String>() {//
//            @Override
//            public void accept(String s) {
//                log.info("炒菜完成：" + s);
//                log.info("吃饭了");
//            }
//        });

        voidCompletableFuture.join();

//
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
//            @Override
//            public String get() {
//                try {
//                    Thread.sleep(2000);
//                    int i = 2/0;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return "result";
//            }
//        });
//        CompletableFuture<String> completableFuture1 = completableFuture.whenComplete(new BiConsumer<String, Throwable>() {
//            @Override
//            public void accept(String s, Throwable throwable) {
//                System.out.println("获取结果：" + s);
//            }
//        });
//        CompletableFuture<String> exceptionally = completableFuture.exceptionally(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) {
//                return "err";
//            }
//        });
//        String s = exceptionally.get();
//        System.out.println(s);
//        String s = completableFuture.get();
//        System.out.println(s);


    }
}
