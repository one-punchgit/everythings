package com.zb.thing.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SimpleSort9 {

    //汉诺塔问题
    public static void hanoi(int n){
        if(n>0){
            func(n,"左","右","中");
        }
    }
    public static void func(int i ,String start,String end,String other){
        if(i==1){
            System.out.println("Move 1 from " + start+" to "+ end);
        }else {
            func(i-1,start,other,end);
            System.out.println("Move 1 from " + start+" to "+ end);
            func(i-1,other,end ,start);
        }
    }
    public static void main(String[] args) {
//        int n = 3;
//        hanoi(3 );
        char[] str = new char[]{'a','b','c'};
        precess(str,0,new ArrayList<Character>());
    }


    //打印一个字符串全部子序列 包括空字符串
    public static void  precess(char[] str, int i, List<Character> res){
        if(i == str.length) {
            res.forEach(x-> System.out.print(x));
            System.out.println();
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        precess(str,i+1,resKeep);
        List<Character> resNoInclude= copyList(res);
        precess(str,i+1,resNoInclude);
    }

    private static List<Character> copyList(List<Character> source){
        List<Character> dir = new ArrayList<>();
        source.forEach(x -> dir.add(x));
        return dir;
    }

    //打印一个字符串全部的排列，不能出现重复

}
