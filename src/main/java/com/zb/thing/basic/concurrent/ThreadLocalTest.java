package com.zb.thing.basic.concurrent;

import com.zb.thing.basic.pojo.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

        // Thread
    //-----------------------------
    //ThreadLocal.ThreadLocalMap threadLocals = null

    // class ThreadLocal{
            // class ThreadLocalMap{
                // Entry[] table
                // class Entry extends WeakReference<ThreadLocal<?>> {
                    //Entry(ThreadLocal<?> k, Object v)
                //}

            //}

    //}


    //线程池 ThreadLocal 可能会造成内存泄露原因 thread 和 ThreadLocalMap 一样不会回收，但是每次new ThreadLocal 导致ThreadLocalMap中元素个数会越来越多，gc后 ThreadLocal会回收 所以Entry[] 中剩余的都是 key=null value=user 的对象













    private static final ThreadLocal<User> context = new ThreadLocal<>();//Thread.currentThread().threadLocals.table


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<User> objectThreadLocal = new ThreadLocal<>();
                    User user = new User("zb", "01");
                    objectThreadLocal.set(user);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");

//
//        User user = new User("zb", "01");
//        context.set(user);//ThreadLocalMap map = getMap(Thread.currentThread());  map.set(this, user);
//        User user1 = context.get();
//        System.out.println(user1);
    }
}
