package com.zb.thing.algorithm;

import java.util.*;

//图
public class SimpleSort6 {
    class Graph{
        HashMap<Integer,Node> nodes;
        HashSet<Edge> edges;

        public Graph(){
            this.nodes = new HashMap<>();
            this.edges= new HashSet<>();
        }
    }
    //图的结构
    class Node{
        int value;
        int in;//出边个数
        int out;//进边个数
        List<Node> nexts;// 出边的邻居节点
        List<Edge> edges;// 出边结构

        public Node(int value){
            this.value = value;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<Node>();
            this.edges = new ArrayList<Edge>();
        }
    }
    class Edge{
        int weight;//边的权重
        Node from;
        Node to;
        public Edge(int weight,Node from,Node to){
            this.weight =weight;
            this.from =from;
            this.to = to;
        }
    }



    //从node出发  宽度优先遍历
    public static void bfs(Node node){
        if(node == null){
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur);

            for (Node next : cur.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    //图的深度优先遍历
    public static void dfs(Node node){
        if(node == null){
            return;
        }
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    //拓扑排序 找到入度0的node 并擦除
    public static  List<Node> sortedTopology(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();//入度为0的点
        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next,inMap.get(next)-1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
