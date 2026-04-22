package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 希尔排序：插入排序的优化版，通过增量间隔将数组分组
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        shellSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int length = arr.length;
        // 初始增量间隔为长度一半，逐步缩小
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int unInsertIndex = gap; unInsertIndex < length; unInsertIndex++) {
                // 待插入的值
                int value = arr[unInsertIndex];
                // 待插入的索引
                int index = unInsertIndex - gap;
                while (index >= 0 && arr[index] > value) {
                    // 后移一位挪出空位
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                arr[index + gap] = value;
            }
        }
    }
}
