package com.wangli.leetcode.algorithm.dp;

public class P416_canPartition {

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        //计算总和
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;

        //定义dp数组：dp[i][j]表示用数组nums(0,,,i)，能装的最大重量，如果 == (sum/2)，则表示能分成两个等合子集
        int[][] dp = new int[n][sum + 1];
        //初始化
        for(int j = 1; j <= sum; j++) {
            if (j >= nums[0]) {
                dp[0][j] = nums[0];
            }
        }

        //状态转移
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= sum; j++){
                if(j - nums[i] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return dp[n - 1][sum] == sum;
    }
}
