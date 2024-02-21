package com.zb.thing.algorithm;

import java.util.PriorityQueue;

public class SimpleSort3 {

    public static void main(String[] args) {
        //优先级队列 -> 小根堆
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(1);
        integers.poll();
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        Test.swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            Test.swap(arr,0,--heapSize);
        }
    }

    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]){
            Test.swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapify(int[] arr,int index,int heapSize){
        int left = 2*index + 1;
        while (left < heapSize){
            int maxChildIndex = left+1 < heapSize && arr[left]<arr[left + 1] ? left +1:left;//最大的孩子索引
            int maxIndex = arr[index]>=arr[maxChildIndex] ? index:maxChildIndex;
            if(maxIndex == index){
                break;
            }
            Test.swap(arr,index,maxIndex);
            index = maxIndex;
            left = 2*index + 1;
        }
    }
}
