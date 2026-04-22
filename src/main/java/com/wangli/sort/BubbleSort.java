package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        bubbleSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;

        // 控制排序的轮数
        for (int count = 0; count < length - 1; count++) {
            // 优化点：提前结束标识
            boolean swapped = false;
            // 控制比较的下标
            for (int index = 0; index < length - 1 - count; index++) {
                if (arr[index] > arr[index + 1]) {
                    swap(arr, index, index + 1);
                    swapped = true;
                }
            }
            // 一次都没交换位置，说明已经排序好了
            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
