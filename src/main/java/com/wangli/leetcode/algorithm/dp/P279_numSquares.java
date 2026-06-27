package com.wangli.leetcode.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class P279_numSquares {

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        int m = list.size();

        // dp[i][j]表示使用list[0,,,i]凑出总和j，使用的最少数量
        int[][] dp = new int[m][n + 1];
        for (int j = 1; j <= n; j++) {
            // 初始化为大于n的数，这样后序使用min()时才能判断
            dp[0][j] = n + 1;
            if (j % list.get(0) == 0) {
                dp[0][j] = j / list.get(0);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - list.get(i) < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - list.get(i)] + 1);
                }
            }
        }

        int res = dp[m - 1][n];

        return res == n + 1 ? -1 : res;
    }
}
