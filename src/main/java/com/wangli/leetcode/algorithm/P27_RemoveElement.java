package com.wangli.leetcode.algorithm;

/**
 * 移除元素
 */
public class P27_RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int size = removeElement(nums, val);
        System.out.println(size);
    }

    /**
     * 快慢指针
     */
    public static int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    /**
     * 暴力法
     */
//    public static int removeElement(int[] nums, int val) {
//        int size = nums.length;
//        for (int i = 0; i < size; i++) {
//            if (nums[i] == val) {
//                for (int j = i + 1; j < size; j++) {
//                    nums[j - 1] = nums[j];
//                }
//                size--;
//                i--;
//            }
//        }
//        return size;
//    }
}
