package com.zb.thing.basic.concurrent;

import java.util.concurrent.*;

public class CompletionServiceTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
        executorCompletionService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "2000";
            }
        });
        executorCompletionService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(4000);
                return "4000";
            }
        });
        executorCompletionService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return "1000";
            }
        });

        for (int i = 0; i < 2; i++) {
            try {
                Object o = executorCompletionService.take().get();
                System.out.println(o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
