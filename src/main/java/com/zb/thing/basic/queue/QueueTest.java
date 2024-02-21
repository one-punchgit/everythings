package com.zb.thing.basic.queue;

import com.zb.thing.basic.pojo.User;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * queue 队列
 */
public class QueueTest {
    // queue和list不通，list可以在任意位置添加删除，queue只有一头进一头出
    // queue的添加、获取并删除、获取方法都有两个方法，区分为异常返回或者null返回
    // 添加元素到队尾	    add(E e)-异常	boolean offer(E e)
    // 取队首元素并删除	E remove()-异常	E poll()
    // 取队首元素但不删除	E element()-异常	E peek()
    public static void main(String[] args) {
        ArrayBlockingQueue<String> stringArrayBlockingQueue = new ArrayBlockingQueue<String>(500);

        String poll = stringArrayBlockingQueue.poll();
        stringArrayBlockingQueue.offer("");
        try {
            stringArrayBlockingQueue.put("");
            stringArrayBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Queue<String> stringQueue = new LinkedList<>();//抽象方式定义 LinkedList实现了queue接口

        //优先级队列的使用
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("a");
        priorityQueue.offer("c");
        priorityQueue.offer("b");

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        //发现打印顺序是 a b c, 和放入顺序不一致
        //优先级队列元素需要实现可比较的接口, 因为string实现了Comparable接口 所以进行默认排序

        //Comparable和Comparator的区别
        //如果有类实现了Comparable 则说明此类支持排序 属于内部排序 默认排序
        //我们有自己定义的类 可以实现Comparator接口 实现外部排序 自定义排序

        //我们有一个User类 定义了排序类UserComparator
        PriorityQueue<User> userComparetorQueue = new PriorityQueue<>(new UserComparator());
        userComparetorQueue.offer(new User("user1","A01"));
        userComparetorQueue.offer(new User("user2","A02"));
        userComparetorQueue.offer(new User("user3","A03"));
        userComparetorQueue.offer(new User("user4","V01"));

        System.out.println(userComparetorQueue.poll());
        System.out.println(userComparetorQueue.poll());
        System.out.println(userComparetorQueue.poll());
        System.out.println(userComparetorQueue.poll());
        System.out.println(userComparetorQueue.poll());
        //结果显示 V01首先获取



    }


}
