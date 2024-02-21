package com.zb.thing.algorithm;

import java.util.LinkedList;

public class SimpleSort12 {

    //Manacher 最长回文子串问题
    public static char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }

    //Manacher
    public static String longestPalindrome(String s) {
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1;
        int cenId = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (max < pArr[i]) {
                max = pArr[i];
                cenId = i;
            }
        }
        // #1#3#4#3#1#  #1#2#2#1#
        // 1 3 4 3 1  1 2 2 1
        int aleng = pArr[cenId] - 1;
        int start = (cenId - pArr[cenId]+1)/2;

        return s.substring(start, start+pArr[cenId]-1);
    }

    public static void main(String[] args) {

        int[] max = {3,5,2,1,7,8};
        int[] maxWindow = getMaxWindow(max, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.println(maxWindow[i]);
        }
        System.out.println(maxWindow);
//        String str = "abcde";
//        String substring = str.substring(0, 4);
//        System.out.println(substring);
//        char[] chars = manacherString("abcdef11");
//        System.out.println(chars);
//        chars[13]++;
//        System.out.println(chars);
//        System.out.println(22 & 1);
//        System.out.println(23 & 1);
//        System.out.println(24 & 1);
//        System.out.println("aaaaa:"+longestPalindrome("aaaaa"));
//        System.out.println("abbaa:"+longestPalindrome("abbaa"));
        System.out.println("cbbd:"+longestPalindrome("cbbd"));
//        System.out.println("aaaaa:"+longestPalindrome("aaaaa"));
//        System.out.println("aaaaa:"+longestPalindrome("aaaaa"));
//        String abc = preProcess("abc");
//        System.out.println(abc);
    }
    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    //滑动窗口最大值
    public static int[] getMaxWindow(int[] arr,int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        //双端队列
        LinkedList<Integer> qmax = new LinkedList<>();

        int[] res = new int[arr.length - w +1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //检查失效位置
            if(qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }

            //是否构成w长度窗口
            if(i>= w-1){
                res[index++]= arr[qmax.peekFirst()];
            }

        }

        return res;

    }

}
