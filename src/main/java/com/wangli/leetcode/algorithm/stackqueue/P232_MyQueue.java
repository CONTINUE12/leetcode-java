package com.wangli.leetcode.algorithm.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P232_MyQueue {

    /**
     * 入栈
     */
    private Deque<Integer> inStack;
    /**
     * 出栈
     */
    private Deque<Integer> outStack;


    public P232_MyQueue() {
        this.inStack = new ArrayDeque<>();
        this.outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        transferInStack2OutStack();
        return outStack.pop();
    }

    public int peek() {
        transferInStack2OutStack();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * 把入栈的数据挪到出栈里
     */
    private void transferInStack2OutStack() {
        if (!outStack.isEmpty()) {
            return;
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
