package com.zb.thing.basic.concurrent.joinTest;

public class JoinTest {
    private static Integer count = 0;
    public static void main(String[] args) {
        Thread thread = new Thread(new JoinThread());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main over");
//        thread.notifyAll();
    }


    static class JoinThread implements Runnable{
        @Override
        public void run() {
            while (true){
                count++;
                System.out.println("run~");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(count == 5){
                    Thread.currentThread().notifyAll();
                }
            }
        }
    }
}
