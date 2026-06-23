package com.wangli.leetcode.algorithm.dp;

public class P746_minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // 爬到第i层台阶需要的最少话费是dp[i]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}
