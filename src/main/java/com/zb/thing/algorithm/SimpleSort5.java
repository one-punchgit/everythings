package com.zb.thing.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SimpleSort5 {


    //二叉树 递归做法 前中后
    public static void preOrderRecur(Node head){
        if(head == null) return ;
        System.out.println(head.value);
        preOrderRecur(head.left);
        System.out.println(head.value);
        preOrderRecur(head.right);
        System.out.println(head.value);
    }

    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    //二叉树 中序遍历 非递归法
    // 左边界入栈 弹出打印 右节点依次
    public static void inOrderUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }


    //二叉树 宽度 就是层序遍历 用队列
    public static void ceng(Node head){
        if(head == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }
    }

    //搜索二叉树
    //校验是否是搜索二叉树
    static int val = Integer.MIN_VALUE;

    public static boolean checkBST(Node<Integer> head){

        if (head == null){
            return true;
        }
        boolean b = checkBST(head.left);
        if(!b) return false;

        if(head.value<=val){
            return false;
        }else {
            val = head.value;
        }
        return checkBST(head.right);
    }

    //是否是完全二叉树
    // 每个节点都有左右；第一个左右不全 后续都是叶子节点



    //是否是平衡二叉树  递归思路 左子树是平衡二叉树 右子树是平衡二叉树 左子树和右子树高差小于等于1
    public static boolean isBalanced(Node head){
        return precess(head).isBalanced;

    }
    public static class ReturnType{
        boolean isBalanced;
        int height;

        ReturnType(boolean isBalanced,int height){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static ReturnType precess(Node x){
        if(x == null){
            return new ReturnType(true,0);
        }

        ReturnType leftData = precess(x.left);
        ReturnType rightData = precess(x.right);

        int height = Math.max(leftData.height,rightData.height) +1;

        boolean isBalanced = leftData.isBalanced && rightData.isBalanced &&(Math.abs(leftData.height-rightData.height)<2);

        return new ReturnType(isBalanced,height);
    }

    //
}
