package com.wangli.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[] {i, map.get(value)};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}
