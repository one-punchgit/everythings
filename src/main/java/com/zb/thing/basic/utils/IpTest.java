package com.zb.thing.basic.utils;

import java.io.IOException;
import java.net.InetAddress;

public class IpTest {
    public static void main(String[] args) {
        try {
            boolean reachable = InetAddress.getByName("10.1.3.55").isReachable(500);
            System.out.println(reachable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
