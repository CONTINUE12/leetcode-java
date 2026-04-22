package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 计数排序
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        countingSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 1. 找到数组中的最大值和最小值
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int range = max - min + 1;

        // 2. 创建计数数组
        int[] count = new int[range];
        for (int num : arr) {
            count[num - min]++;
        }

        // 3. 计算前缀和（确定每个元素的最终位置）
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // 4. 创建临时数组存放排序结果
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            int pos = count[num - min] - 1;
            output[pos] = num;
            count[num - min]--;
        }

        // 5. 拷贝回原数组
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
