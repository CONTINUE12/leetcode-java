package com.wangli.leetcode.algorithm.dp;

public class P1049_lastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        //计算总和
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int mid = sum / 2;

        //定义dp数组：dp[i][j]表示用数组nums(0,,,i)，能装的最大重量
        int[][] dp = new int[n][mid + 1];
        //初始化
        for (int j = stones[0]; j <= mid; j++) {
            dp[0][j] = stones[0];
        }

        //状态转移
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= mid; j++){
                if(j - stones[i] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }

        return sum - dp[n - 1][mid] - dp[n - 1][mid];
    }
}
