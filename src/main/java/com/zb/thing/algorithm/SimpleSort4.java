package com.zb.thing.algorithm;


import java.util.HashMap;

public class SimpleSort4 {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> random;

        Node(E element) {
            this.item = element;
        }
    }
    public static Node copyListWithRand1(Node head){
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        Node cur = head;

        while (cur != null){
            nodeNodeHashMap.put(cur,new Node(cur.item));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            nodeNodeHashMap.get(cur).next = nodeNodeHashMap.get(cur.next);
            nodeNodeHashMap.get(cur).random  = nodeNodeHashMap.get(cur.random);
            cur = cur.next;
        }
        return nodeNodeHashMap.get(head);
    }

    //找到链表第一个入环节点 如果无环 返回null
    public static Node getLoopNode(Node node){
        if(node == null || node.next == null || node.next.next == null){
            return null;
        }

        Node n1 = node.next;
        Node n2 = node.next.next;

        while (n1!= n2){
            if(n2.next == null|| n2.next.next == null) return null;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = node;

        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    //两个链表是否相交 一次遍历end和长度len  if(end1 == end2)有交集， 哪个len长 node先走插值步，相遇节点就是交点
}
