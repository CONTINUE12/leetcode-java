package com.wangli.leetcode.algorithm;

import com.alibaba.fastjson.JSON;

public class P59_GenerateMatrix {

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = generateMatrix(n);
        System.out.println(JSON.toJSON(matrix));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startX = 0;
        int startY = 0;
        int row = 0;
        int column = 0;
        int offset = 1;
        int loop = n / 2;
        int count = 1;

        while (loop-- > 0) {
            row = startX;
            column = startY;

            // 上边
            for (; column < n - offset; column++) {
                matrix[row][column] = count++;
            }
            // 右边
            for (; row < n - offset; row++) {
                matrix[row][column] = count++;
            }
            // 下边
            for (; column > startY; column--) {
                matrix[row][column] = count++;
            }
            // 左边
            for (; row > startX; row--) {
                matrix[row][column] = count++;
            }

            startX++;
            startY++;
            offset++;
        }

        // 判断奇偶数
        if (n % 2 == 1) {
            matrix[startX][startY] = count;
        }

        return matrix;
    }
}
