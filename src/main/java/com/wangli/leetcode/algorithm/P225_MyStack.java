package com.wangli.leetcode.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

public class P225_MyStack {

    private Queue queue;
    private Queue tmpQueue;

    public P225_MyStack() {
        this.queue = new ArrayDeque();
        this.tmpQueue = new ArrayDeque();
    }

    public void push(int x) {
        while (!queue.isEmpty()) {
            tmpQueue.offer(queue.poll());
        }
        queue.offer(x);
        while (!tmpQueue.isEmpty()) {
            queue.offer(tmpQueue.poll());
        }
    }

    public int pop() {
        return (int) queue.poll();
    }

    public int top() {
        return (int) queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
