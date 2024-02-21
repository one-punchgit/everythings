package com.zb.thing.algorithm;

public class SimpleSort2 {

    public static int getMax(int[] arr){
        int[] a = new int[]{0,1};
        if(arr.length == 0) return 0;
        return process(arr,0,arr.length - 1);
    }

    public static int process(int[] arr,int l ,int r){
        if(l == r) return arr[l];
        int mid = l + (l + r)>>1;
        int maxL = process(arr,l ,mid);
        int maxR = process(arr,mid + 1,r);
        return Math.max(maxL,maxR);

    }


    //归并
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2) return ;
        mergeProcess(arr,0,arr.length-1);
    }

    public static void mergeProcess(int[] arr,int L ,int R){
        if(L == R) return ;
        int mid = L + (R - L) >> 1;
        mergeProcess(arr,L ,mid);
        mergeProcess(arr,mid + 1,R);
        merge(arr,L,mid,R);
    }
    // 3 2 4 8 2 1
    // 0 1 2 3 4 5
    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++] ;
        }
        while(p2 <= R){
            help[i++] = arr[p2++] ;
        }
        for (int j = 0; j < help.length; j++) {
            arr[L++] = help[j];
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //快排
    public static void quickSort(int[] arr, int L, int R) {
        // 3 0 2 9 4
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);//随机找一个
            int[] partition = partition(arr, L, R);
            quickSort(arr, L, partition[0] - 1);
            quickSort(arr, partition[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

}
