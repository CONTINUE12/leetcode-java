package com.wangli.leetcode.algorithm.stackqueue;

import java.util.*;

public class P20_isValid {

    public static void main(String[] args) {
        String s = "()[}{}";
        boolean res = isValid(s);
        System.out.println(res);
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        // 存储括号映射
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 判断栈顶元素是否和当前括号匹配
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                // 入栈
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
