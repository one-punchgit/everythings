package com.zb.thing.basic.jvm;

import com.zb.thing.basic.pojo.User;
import com.zb.thing.basic.pojo.User1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest {
    public static List<Object> list = new ArrayList<>();

    // -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintHeapAtGC -XX:+PrintGCDateStamps  -XX:HeapDumpPath=D:\jvm.dump
    public static void main(String[] args) {
        try {
            Thread.sleep(18000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User1(i++, UUID.randomUUID().toString()));
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            new User1(j--,"");
        }
    }
}
