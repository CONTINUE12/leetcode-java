package com.wangli.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class P454_FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // key：num1 + num2元素之和，value：出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        // 应用两数之和思想，便利num3 + num4
        for (int i : nums3) {
            for (int j : nums4) {
                int value = 0 - i - j;
                res += map.getOrDefault(value, 0);
            }
        }

        return res;
    }
}
