package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.ListNode;

public class P19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode(-1);
        virtual.next = head;
        ListNode fast = virtual;
        ListNode slow = virtual;

        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return virtual.next;
    }
}
