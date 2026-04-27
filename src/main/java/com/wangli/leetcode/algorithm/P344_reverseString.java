package com.wangli.leetcode.algorithm;

import com.alibaba.fastjson.JSON;

public class P344_reverseString {

    public static void main(String[] args) {
        char[] s = new char[] {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(JSON.toJSON(s));
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

}
