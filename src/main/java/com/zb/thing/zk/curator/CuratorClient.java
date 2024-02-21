package com.zb.thing.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorClient {
    public static void main(String[] args) throws Exception{
        CuratorFramework build = CuratorFrameworkFactory.builder().connectString("").sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).namespace("").build();
        build.start();
        String s = build.create().forPath("/for");

    }
}
