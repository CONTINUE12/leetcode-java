package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.ListNode;

public class P141_HasCycle {

    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
