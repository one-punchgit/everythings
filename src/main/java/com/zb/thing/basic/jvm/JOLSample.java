package com.zb.thing.basic.jvm;

import com.zb.thing.basic.collection.ListTest;
import com.zb.thing.basic.pojo.User;
import org.openjdk.jol.info.ClassLayout;

import java.nio.file.Paths;

public class JOLSample {
    public static void main(String[] args) {

        String path = "/uar/1/2/file/aa/abc.txt";

        String s = Paths.get(path).getFileName().toString();
        String s1 = Paths.get(path).getParent().toString();
        System.out.println(s);
        System.out.println(s1);
//        User user = new User();
//        user.setName("zhuge");
//        ClassLayout layout1 = ClassLayout.parseInstance(user);
//        System.out.println(layout1.toPrintable());
//
//        ClassLayout layout = ClassLayout.parseInstance(new User());
//        System.out.println(layout.toPrintable());


        System.out.println();
    }
}
