package com.zb.thing.basic.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列 Double Ended Queue
 */
public class DequeTest {
    public static void main(String[] args) {
        //addLast(E e) / offerLast(E e)
        //E removeFirst() / E pollFirst()
        //E getFirst() / E peekFirst()
        //addFirst(E e) / offerFirst(E e)
        //E removeLast() / E pollLast()
        //E getLast() / E peekLast()
        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("1");

    }
}
