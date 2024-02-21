package com.zb.thing.basic.jvm;

import sun.misc.Launcher;

import java.net.URL;

public class Tes {
    public static void main(String[] args) {
        System.out.println("main");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }
    }
}
