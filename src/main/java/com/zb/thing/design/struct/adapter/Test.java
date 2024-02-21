package com.zb.thing.design.struct.adapter;

import java.util.concurrent.Callable;

/**
 * 结构型模式-适配器
 */
public class Test {
    public static void main(String[] args) {

        Callable<Long> callable = new Task(1024);
//        Thread thread = new Thread(callable); // compile error! Thread 需要Runnable参数，编译错误 如果修改Task类，会导致一系列导入改类的方法都需要修改
//        thread.start();

        //构建适配类 RunnableAdapter
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}
