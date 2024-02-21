package com.zb.thing.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class RedisClient {
    public static void main(String[] args) {
        RedissonClient redissonClient = Redisson.create();
        RLock lock = redissonClient.getLock("");
        lock.lock();
        lock.unlock();
    }
}
