package com.wangli.leetcode.algorithm.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1047_removeDuplicates {

    public String removeDuplicates(String s) {
        // 使用栈匹配消除相邻且相同元素
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty() && deque.peek() == c) {
                deque.pop();
            } else {
                deque.push(c);
            }
        }

        if (deque.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pop());
        }

        return res.reverse().toString();
    }
}
