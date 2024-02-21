package com.zb.thing.basic.compare;

import java.util.ArrayList;
import java.util.Collections;

public class CompareTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("声音超阈值异常");
        arrayList.add("声音趋势异常,声音超阈值异常");
        arrayList.add("声音趋势异常,声音动态阈值异常");
        arrayList.add("声音趋势异常,声音动态阈值异常,声音超阈值异常");
        arrayList.add("声音动态阈值异常,声音超阈值异常");
        Collections.sort(arrayList);
        System.out.println(arrayList);


        char a = '超';
        char b = '趋';
        System.out.println(a-b);
        System.out.println("超".charAt(0));
        System.out.println("趋".charAt(0));
    }
}
