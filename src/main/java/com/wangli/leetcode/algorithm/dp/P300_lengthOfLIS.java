package com.wangli.leetcode.algorithm.dp;

public class P300_lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以 nums[i] 结尾的最长递增子序列长度
        int[] dp = new int[n];
        // 初始化每个位置最小长度为1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
