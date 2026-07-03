package com.wangli.leetcode.algorithm.hash;

public class P242_IsAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }

    public static boolean isAnagram(String s, String t) {
        int[] records = new int[26];

        // 记录s中每个字母的数量
        for (int index = 0; index < s.length(); index++) {
            char si = s.charAt(index);
            records[si - 'a']++;
        }

        // 匹配t中每个字母
        for (int index = 0; index < t.length(); index++) {
            char ti = t.charAt(index);
            records[ti - 'a']--;
        }

        // 看一下是否完全匹配
        for (int index = 0; index < records.length; index++) {
            if (records[index] != 0) {
                return false;
            }
        }

        return true;
    }
}
