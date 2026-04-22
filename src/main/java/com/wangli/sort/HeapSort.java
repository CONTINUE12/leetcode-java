package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        heapSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;

        // 构建大顶堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        // 提取堆顶元素并调整堆
        for (int i = length - 1; i > 0; i--) {
            // 交换堆顶（最大值）和当前末尾元素
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整剩余元素为大顶堆
            heapify(arr, i, 0);
        }
    }

    // 堆化操作
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 根节点
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 找出最大元素
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 若最大元素不是根节点，交换并递归堆化
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}
