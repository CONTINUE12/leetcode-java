package com.wangli.leetcode.algorithm.dp;

public class P322_coinChange {

    public int coinChange(int[] coins, int amount) {
        // dp[i][j]表示使用coins[0,,,i]凑出金额j，使用的最少硬币数
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 1; j <= amount; j++) {
            // 初始化为大于amount的数，这样后序使用min()时才能判断
            dp[0][j] = amount + 1;
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }

        int res = dp[coins.length - 1][amount];

        return res == amount + 1 ? -1 : res;
    }

}
