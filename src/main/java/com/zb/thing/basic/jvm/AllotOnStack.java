package com.zb.thing.basic.jvm;

import com.zb.thing.basic.pojo.EscapeAnalysisPojo;
import com.zb.thing.basic.pojo.User;

// ‐Xmx15m ‐Xms15m ‐XX:+DoEscapeAnalysis ‐XX:+PrintGC ‐XX:+EliminateAllocations
public class AllotOnStack {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    private static void alloc() {
        Object o = new Object();
//        EscapeAnalysisPojo escapeAnalysisPojo = new EscapeAnalysisPojo();
//        escapeAnalysisPojo.setName("zhuge");
    }
}
