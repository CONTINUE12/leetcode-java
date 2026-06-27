package com.wangli.leetcode.algorithm.dp;

public class P518_change {

    public int change(int amount, int[] coins) {
        // dp[i][j]表示使用coins[0,,,i]凑出金额amount的组合数
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }
}
