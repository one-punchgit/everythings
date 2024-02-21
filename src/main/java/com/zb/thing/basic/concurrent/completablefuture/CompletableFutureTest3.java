package com.zb.thing.basic.concurrent.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Slf4j
public class CompletableFutureTest3 {
    public static void main(String[] args) {
        //洗水壶 烧开水 泡茶
        //洗茶壶 洗茶杯 拿茶叶
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                log.info("洗水壶");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("烧开水");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                log.info("洗茶壶");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("洗茶杯");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("拿茶叶");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "茶叶";
            }
        });
        CompletableFuture<String> completableFuture = completableFuture1.thenCombine(completableFuture2, new BiFunction<Void, String, String>() {
            @Override
            public String apply(Void unused, String s) {
                log.info("拿到茶叶：{}", s);
                return "开始泡茶";
            }
        });
        String join = completableFuture.join();
        System.out.println(join);

    }
}
