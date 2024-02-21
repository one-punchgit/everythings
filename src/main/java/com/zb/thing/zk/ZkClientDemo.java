package com.zb.thing.zk;

import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

public class ZkClientDemo {
    private static final String CONNECT_STR = "127.0.0.1:2181";
    private final static String CLUSTER_CONNECT_STR = "192.168.65.156:2181,192.168.65.190:2181,192.168.65.200:2181";

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STR, 4000, watchedEvent -> {
            if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                countDownLatch.countDown();
                System.out.println("建立连接");
            }
        });
        System.out.println("连接中");
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
        zooKeeper.create("/user", "zb".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
}
