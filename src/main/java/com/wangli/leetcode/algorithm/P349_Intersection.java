package com.wangli.leetcode.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

public class P349_Intersection {

    public static void main(String[] args) {
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        int[] res = intersection(num1, num2);
        System.out.println(JSON.toJSON(res));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                res.add(num);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
