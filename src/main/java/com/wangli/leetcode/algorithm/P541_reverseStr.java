package com.wangli.leetcode.algorithm;

public class P541_reverseStr {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = reverseStr(s, k);
        System.out.println(res);
    }

    public static String reverseStr(String s, int k) {
        char[] charS = s.toCharArray();

        for (int i = 0; i < charS.length; i += k * 2) {
            int start = i;
            int end = Math.min(start + k - 1, charS.length - 1);
            reverseSubStr(charS, start, end);
        }

        return new String(charS);
    }

    /**
     * 翻转函数
     */
    public static void reverseSubStr(char[] charS, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = charS[startIndex];
            charS[startIndex] = charS[endIndex];
            charS[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }

}
