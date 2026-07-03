package com.wangli.leetcode.algorithm.dp;

public class P647_countSubstrings {

    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        // 每个点都做2种中心
        for (int i = 0; i < n; i++) {
            res += expand(s, i, i);     // 奇数中心 [i,i]
            res += expand(s, i, i + 1); // 偶数中心 [i,i+1]
        }
        return res;
    }

    // left、right 是扩散的左右起点
    private static int expand(String s, int left, int right) {
        int cnt = 0;
        // 只要不越界，且左右字符相等，就是回文
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++; // 找到一个回文，计数+1
            left--;  // 往左扩一位
            right++; // 往右扩一位
        }
        return cnt;
    }
}
