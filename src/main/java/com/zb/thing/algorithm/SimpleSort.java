package com.zb.thing.algorithm;

public class SimpleSort {


    public static void main(String[] args) {

        int[] a = {1, 2, 3, 1, 3, 4, 5, 2};
        selectSort(a);
        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i]);
        }
        System.out.println();
        System.out.println(1 & 2);
        System.out.println(1 & 1);
        System.out.println(1 ^ 2);
        System.out.println(3 & (~3 + 1));//提取最右的一
        //00000011
        //11111100
        //11111101
        //00000001
    }

    //冒泡
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) { //0  - i
            for (int j = 0; j < i; j++) {// j - i
                if (arr[j] > arr[j + 1]) {//从头 两两比较
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //选择
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //0-i上有序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
