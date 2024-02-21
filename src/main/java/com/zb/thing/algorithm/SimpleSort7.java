package com.zb.thing.algorithm;

import java.util.PriorityQueue;

//前缀树和贪心算法
public class SimpleSort7 {


    //贪心算法  哈夫曼树
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size()>1){
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }

        return sum;
    }



    //N皇后问题
    public static boolean isValid(int[] record,int i ,int j){
        for(int k = 0;k<j;k++){
            if(j == record[k] || Math.abs(record[k]-j) == Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

    public static int process1(int i ,int [] record,int n ){
        if(i == n){
            return 1;
        }
        int res = 0;
        for(int j= 0;j<n;j++){
            if(isValid(record,i,j)){
                record[i] = j;
                res +=process1(i+1,record,n);

            }
        }
        return res;
    }

    public static int num1(int n){
        if(n < 1){
            return 0;
        }
        return process1(0,new int[n],n);
    }
}
