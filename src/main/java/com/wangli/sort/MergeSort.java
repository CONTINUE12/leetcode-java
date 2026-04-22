package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        mergeSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // 递归分割左半部分
            sort(arr, left, mid, temp);
            // 递归分割右半部分
            sort(arr, mid + 1, right, temp);
            // 合并两个有序数组
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并两个有序数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左数组起始索引
        int i = left;
        // 右数组起始索引
        int j = mid + 1;
        // 临时数组索引
        int k = 0;

        // 临时数组索引
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 拷贝左数组剩余元素
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 拷贝右数组剩余元素
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将临时数组内容拷贝回原数组
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
    }
}
