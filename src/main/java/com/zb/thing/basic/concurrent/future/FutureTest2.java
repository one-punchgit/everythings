package com.zb.thing.basic.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest2 {
    public static void main(String[] args) {
        FutureTask<String> futureTask2 = new FutureTask<>(new Task2());//洗茶壶 洗茶杯 拿茶叶
        new Thread(futureTask2).start();
        FutureTask<String> futureTask1 = new FutureTask<>(new Task1(futureTask2));//洗水壶 烧开水 泡茶
        new Thread(futureTask1).start();
        try {
            String s = futureTask2.get();
            String s1 = futureTask1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
