package com.zb.thing.basic.utils;


public class FileTest {
    public static void main(String[] args) {

        String url = "/tmp/20231126-2023123-健康报告.pdf";
        String[] split = url.split("\\/");

        System.out.println(split);
    }
}
