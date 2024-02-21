package com.zb.thing.basic.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class FixedSizeCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public FixedSizeCache(int maxSize) {
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }

    public static void main(String[] args) {
        int cacheSize = 5;
        FixedSizeCache<String, Object> cache = new FixedSizeCache<>(cacheSize);
        Object o = cache.get("");


        // 初始化数据
        for (int i = 0; i < 10; i++) {
            String jobId = "jobId" + i;
            Object data = new Object();
            cache.put(jobId, data);
        }

        // 添加新数据
        String newJobId = "newJobId";
        Object newData = new Object();
        cache.put(newJobId, newData);

        // 输出缓存中的数据
        for (Map.Entry<String, Object> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
