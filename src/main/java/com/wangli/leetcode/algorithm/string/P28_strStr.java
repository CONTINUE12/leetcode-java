package com.wangli.leetcode.algorithm.string;

public class P28_strStr {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        int res = strStr(haystack, needle);
        System.out.println(res);
    }

    /**
     * 暴力匹配
     *
     */
//    public static int strStr(String haystack, String needle) {
//        if (haystack.length() == 0 || needle.length() == 0 || haystack.length() < needle.length()) {
//            return -1;
//        }
//
//        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//            int a = i;
//            int b = 0;
//            while (b < needle.length() && needle.charAt(b) == haystack.charAt(a)) {
//                a++;
//                b++;
//            }
//
//            if (b == needle.length()) {
//                return i;
//            }
//        }
//
//        return -1;
//    }

    /**
     * KMP，前缀表方式实现
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }

        // 计算前缀表，用于字符不匹配时回退下标
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 不匹配，回退模式串下标
            while (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = next[j - 1];
            }
            // 匹配，下标右移
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 判断是否匹配完成
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }

    /**
     * 获取前缀表
     */
    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            // 前后缀不相等，回退
            while (s.charAt(i) != s.charAt(j) && j > 0) {
                j = next[j - 1];
            }
            // 前后缀相等
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            // 更新前缀表
            next[i] = j;
        }
    }
}
