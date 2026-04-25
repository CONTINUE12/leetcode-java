package com.wangli.leetcode.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_FourSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,2,2,2};
        List<List<Integer>> res = fourSum(nums, 8);
        System.out.println(JSON.toJSON(res));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 双指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> subRes = new ArrayList<>(4);
                        subRes.add(nums[i]);
                        subRes.add(nums[j]);
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
        }

        return res;
    }
}
