package com.zb.thing.basic.concurrent.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

//洗茶壶 洗茶杯 拿茶叶
@Slf4j
public class Task2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        log.info("洗茶壶");
        Thread.sleep(1000);
        log.info("洗茶杯");
        Thread.sleep(1000);
        log.info("拿茶叶");
        return "茶叶";
    }
}
