package com.wangli.sort;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,22,4,12};
        insertionSort(arr);
        System.out.println(JSON.toJSON(arr));
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int length = arr.length;
        // 默认第一个是排序好的
        for (int unInsertIndex = 1; unInsertIndex < length; unInsertIndex++) {
            // 待插入的值
            int value = arr[unInsertIndex];
            // 待插入的索引
            int index = unInsertIndex - 1;
            while (index >= 0 && arr[index] > value) {
                // 后移一位挪出空位
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }
}
