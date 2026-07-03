package com.wangli.leetcode.algorithm.dp;

public class P674_findLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // dp[i]表示以i结尾的最长连续子序列
        int[] dp = new int[n];
        // 初始化，每个元素自身长度1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            // 更新全局最大值
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
