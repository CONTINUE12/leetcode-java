package com.wangli.leetcode.algorithm.dp;

public class P198_rob {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i]表示偷窃第i个房屋时能偷窃到的最高金额
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
