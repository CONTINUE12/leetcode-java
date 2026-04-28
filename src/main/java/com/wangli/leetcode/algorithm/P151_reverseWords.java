package com.wangli.leetcode.algorithm;

public class P151_reverseWords {

    public static void main(String[] args) {
        String s = "a good   example";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();

        int fast = s.length() - 1;
        int slow = s.length() - 1;
        while (fast >= 0) {
            while (fast >= 0 && s.charAt(fast) != ' ') {
                fast--;
            }

            // 添加单词
            res.append(s.substring(fast + 1, slow + 1)).append(" ");

            // 跳过单词之间多余的空格
            while (fast >= 0 && s.charAt(fast) == ' ') {
                fast--;
            }
            slow = fast;
        }

        return res.toString().trim();
    }
}
