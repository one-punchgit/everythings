package com.zb.thing.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//207. 课程表
public class Code207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();//i位置存的 边集合
        int[] indeg = new int[numCourses];//入度

        for(int i = 0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());

        }
        for(int[] i : prerequisites){
            list.get(i[1]).add(i[0]);
            indeg[i[0]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){
                queue.add(i);
            }
        }
//        for(int i : indeg){
//            if(i==0){
//                queue.add(i);
//            }
//        }
        int res = 0;

        while(!queue.isEmpty()){
            int pop = queue.poll();
            res++;
            for(int i: list.get(pop)){
                indeg[i]--;
                if(indeg[i] == 0){
                    queue.add(i);
                }

            }


        }
        return res == numCourses;

    }

    public static void main(String[] args) {
        int[][] pre = new int[][]{{0,1}};
        canFinish(2,pre);




    }
}
