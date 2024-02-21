package com.zb.thing.basic.collection;

import com.zb.thing.basic.pojo.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("zb","1"));
        users.add(new User("zb1","2"));
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            System.out.println(next);
        }
    }
}
