package com.wangli.leetcode.algorithm.string;

/*
 * 充分条件：如果字符串s是由重复子串组成的，那么它的最长相等前后缀不包含的子串一定是s的最小重复子串。
 * 必要条件：如果字符串s的最长相等前后缀不包含的子串是s的最小重复子串，那么s必然是由重复子串组成的。
 * 推得：当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时，不包含的子串就是s的最小重复子串。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class P459_repeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length == 0) {
            return false;
        }

        // 计算前缀表
        int[] next = new int[length];
        getNext(next, s);

        // 没有公共前后缀，按照题目要求返回false
        if (next[length - 1] == 0) {
            return false;
        }

        // 最长公共前后缀不包含的字串长度，如果能被s整除，则说明s是由重复字串组成
        int res = length % (length - next[length - 1]);
        if (res == 0) {
            return true;
        }

        return false;
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
