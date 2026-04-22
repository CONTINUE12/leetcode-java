package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        selectionSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;

        // 标识已排序的下标位置
        for (int alreadySortIndex = 0; alreadySortIndex < length - 1; alreadySortIndex++) {
            // 最小索引
            int minIndex = alreadySortIndex;
            // 从未排序的数组中找到最小值的索引
            for (int unSortIndex = alreadySortIndex + 1; unSortIndex < length; unSortIndex++) {
                if (arr[unSortIndex] < arr[minIndex]) {
                    minIndex = unSortIndex;
                }
            }

            if (minIndex != alreadySortIndex) {
                swap(arr, alreadySortIndex, minIndex);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
