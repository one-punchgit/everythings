package com.zb.thing.algorithm;

import java.util.Comparator;

public class MyComparator implements Comparator<SimpleSort6.Edge> {
    @Override
    //c.compare(dest[j-1], dest[j])>0
    public int compare(SimpleSort6.Edge o1,SimpleSort6.Edge o2) {
        return o1.weight - o2.weight;
    }
}
