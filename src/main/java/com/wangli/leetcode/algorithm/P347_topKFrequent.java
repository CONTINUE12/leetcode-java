package com.wangli.leetcode.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347_topKFrequent {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println(JSON.toJSON(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 统计频率
        Map<Integer, Integer> num2CountMap = new HashMap<>();
        for (int num : nums) {
            num2CountMap.put(num, num2CountMap.getOrDefault(num, 0) + 1);
        }

        // 通过优先级队列对出现频率排序，升序
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });
        for (Map.Entry<Integer, Integer> entry : num2CountMap.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();

            if (pq.size() < k) {
                pq.add(new int[] {num, count});
            } else {
                if (count > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[] {num, count});
                }
            }
        }

        // 收集前k个高频元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }
}
