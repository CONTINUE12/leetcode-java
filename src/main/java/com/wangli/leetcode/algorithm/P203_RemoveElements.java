package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.ListNode;

public class P203_RemoveElements {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;

        ListNode current = virtualHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return virtualHead.next;
    }
}
