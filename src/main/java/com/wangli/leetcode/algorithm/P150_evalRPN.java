package com.wangli.leetcode.algorithm;

import java.util.*;

public class P150_evalRPN {

    public static void main(String[] args) {
        String[] tokens = new String[] {"4","13","5","/","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    public static int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            // 遇到数字入栈
            if (!set.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // 运算符
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int res;
                if (Objects.equals(token, "+")) {
                    res = num2 + num1;
                } else if (Objects.equals(token, "-")) {
                    res = num2 - num1;
                } else if (Objects.equals(token, "*")) {
                    res = num2 * num1;
                } else {
                    res = num2 / num1;
                }
                stack.push(res);
            }
        }

        return stack.pop();
    }
}
