package com.zb.thing.algorithm;

public class SimpleSort18 {

    //找到>=value 最左位置 R是右边界
    //二分方法
    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int maxPoint(int[] arr, int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int near = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - near + 1);
        }
        return res;
    }
}
