package com.zb.thing.basic.concurrent.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureTest {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "result";
            }
        });
//        new Thread(futureTask).start();
//        try {
//            boolean done = futureTask.isDone();
//            System.out.println(done);//查看是否完成
//            Object o = futureTask.get();//阻塞的
//            System.out.println(o);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        FutureTask futureTask1 = new FutureTask(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        },"runnable result");
//
//        new Thread(futureTask1).start();
//        try {
//            Object o = futureTask1.get();
//            System.out.println(o);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //为什么要用Future 目的是在未来主线程可以调用异步的结果查看是否返回结果
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<?> submit1 = executorService.submit(futureTask);
        try {
            Object o = submit1.get();//get null
            System.out.println(o);

            Object o1 = futureTask.get();
            System.out.println(o1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        Future<String> submit = executorService.submit(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "call result";
//        });
//        try {
//            String s = submit.get();
//            log.info(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
