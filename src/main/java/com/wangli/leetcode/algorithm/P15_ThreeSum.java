package com.wangli.leetcode.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class P15_ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[] {-2,0,1,1,2};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(JSON.toJSON(res));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> subRes = new ArrayList<>(3);
                    subRes.add(nums[i]);
                    subRes.add(nums[left]);
                    subRes.add(nums[right]);
                    res.add(subRes);

                    // 去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
            }
        }

        return res;
    }

}
