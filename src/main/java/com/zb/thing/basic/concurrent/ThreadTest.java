package com.zb.thing.basic.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        System.out.println(myThread.getState());//NEW
        System.out.println(myThread.isInterrupted());
        myThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();//myThread sleep中被打断会被捕获异常 所以导致打断无效

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main over~");



    }



}

class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.interrupt();
            }
            System.out.println(n++);
        }
    }
}

// Callable 使用线程池的submit提交任务
class MyCall implements Callable<String>{

    @Override
    public String call() throws Exception {
        return null;
    }
}
