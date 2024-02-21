package com.zb.thing.algorithm.leetcode;

import java.util.Arrays;

//322. 零钱兑换
public class Code322 {
    public int coinChange(int[] coins, int amount) {

        if(coins.length==0){
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >=0){
                    dp[i] = Math.min(dp[i],(dp[i-coins[j]]+1));
                }
            }

        }

        return dp[amount] == amount+1?-1:dp[amount];


    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                if(matrix[i][i1] ==  target){
                    return true;
                }
            }
        }

        return false;


    }
}
