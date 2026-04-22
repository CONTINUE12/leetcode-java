package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        quickSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            // 获取基准位置
            int pivotIndex = partition(arr, left, right);
            // 排序左半部分
            sort(arr, left, pivotIndex - 1);
            // 排序右半部分
            sort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // 选最右元素为基准
        int pivot = arr[right];
        // 记录小于基准区域的边界
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 交换元素到小于基准区域
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准放到正确位置
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        // 返回基准索引
        return i + 1;
    }
}
