package com.zb.thing.basic.concurrent;


import lombok.extern.slf4j.Slf4j;

/**
 * 停止线程 测试类
 */
@Slf4j
public class Interrupted {

    private Thread thread;
    private volatile boolean isInterrupt = false;

    public synchronized void start(){
        thread = new Thread(() -> {
            while (!isInterrupt){
                try {
                    log.info("执行中~");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();

                }
            }
            log.info("执行完");
        });
        thread.start();
    }

    public synchronized void stop(){
        log.info("中断执行");
        isInterrupt = true;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupted();
    }
}
