package com.zb.thing.algorithm;

public class SimpleSort13 {

    //树形dp  最长节点
    public static class Info{
        int maxDistance;
        int height;
        public Info(int dis,int h){
            this.maxDistance = dis;
            this.height = h;
        }
    }

    //返回以x为头 整棵树的信息
    public static Info precess(Node x){
        if(x == null){
            return new Info(0,0);
        }

        Info left = precess(x.left);
        Info right = precess(x.right);

        int distance = Math.max(left.maxDistance,right.maxDistance);
        int height = Math.max(left.height,right.height) + 1;
        int maxDistance= Math.max(left.height+right.height+1,distance);
        return new Info(maxDistance,height);
    }
}
