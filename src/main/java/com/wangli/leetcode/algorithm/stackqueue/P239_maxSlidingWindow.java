package com.wangli.leetcode.algorithm.stackqueue;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class P239_maxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[] {1,-1};
        int k = 1;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(JSON.toJSON(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        // 维护一个单调队列，头部最大，尾部最小
        Deque<Integer> deque = new ArrayDeque<>();

        // 先处理前k个元素
        for (int i = 0; i < k; i++) {
            add(deque, nums[i]);
        }
        res[resIndex++] = deque.peek();

        // 处理窗口滑动
        for (int i = k; i < nums.length; i++) {
            // 出队列
            poll(deque, nums[i - k]);
            // 入队列
            add(deque, nums[i]);
            // 获取窗口最大值
            res[resIndex++] = deque.peek();
        }

        return res;
    }

    /**
     * 入队逻辑
     */
    private static void add(Deque<Integer> deque, int value) {
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.removeLast();
        }
        deque.add(value);
    }

    /**
     * 出队逻辑
     */
    private static void poll(Deque<Integer> deque, int value) {
        if (!deque.isEmpty() && Objects.equals(deque.peek(), value)) {
            deque.poll();
        }
    }

}
