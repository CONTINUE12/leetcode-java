package com.wangli.leetcode.algorithm;

public class P209_MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int leftIndex = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int rightIndex = 0; rightIndex < nums.length; rightIndex++) {
            sum += nums[rightIndex];
            while (sum >= target) {
                minLength = Math.min(minLength, rightIndex - leftIndex + 1);
                sum -= nums[leftIndex];
                leftIndex++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
