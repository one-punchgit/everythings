package com.zb.thing.basic.concurrent.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//洗水壶 烧开水 泡茶
@Slf4j
public class Task1 implements Callable<String> {
    private FutureTask<String> task2;

    public Task1(FutureTask<String> task2){
        this.task2 = task2;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        log.info("洗水壶");
        Thread.sleep(1000);
        log.info("烧开水");
        String s = task2.get();
        Thread.sleep(1000);
        log.info("泡茶:"+s);
        return null;
    }
}
