package com.zb.thing.basic.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASTest {
    private static volatile int i = 0;
    static AtomicInteger atomicInteger  = new AtomicInteger(0);
    static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,1);
    static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(1,false);

    public static void main(String[] args) {
        new Thread(() -> {
            for (int j = 0; j < 100000; j++) {
//                atomicStampedReference.compareAndSet(i,2,1,1);
                int i = atomicInteger.incrementAndGet();
            }
        }).start();
        new Thread(() -> {
            for (int j = 0; j < 100000; j++) {
                int i = atomicInteger.incrementAndGet();
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.get());


//        Entity entity = new Entity();
//
//        Unsafe unsafe = UnsafeFactory.getUnsafe();
//
//        long offset = UnsafeFactory.getFieldOffset(unsafe, Entity.class, "x");
//
//        boolean successful;
//
//        // 4个参数分别是：对象实例、字段的内存偏移量、字段期望值、字段新值
//        successful = unsafe.compareAndSwapInt(entity, offset, 0, 3);
//        System.out.println(successful + "\t" + entity.x);
//
//        successful = unsafe.compareAndSwapInt(entity, offset, 3, 5);
//        System.out.println(successful + "\t" + entity.x);
//
//        successful = unsafe.compareAndSwapInt(entity, offset, 3, 8);
//        System.out.println(successful + "\t" + entity.x);
    }
}

class UnsafeFactory {

    /**
     * 获取 Unsafe 对象
     *
     * @return
     */
    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long getFieldOffset(Unsafe unsafe, Class c, String filename) {
        try {
            return unsafe.objectFieldOffset(c.getDeclaredField(filename));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }
}


class Entity {
    int x;
}