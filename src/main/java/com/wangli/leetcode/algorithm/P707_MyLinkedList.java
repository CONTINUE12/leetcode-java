package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.ListNode;

public class P707_MyLinkedList {

    private ListNode virtualHead;

    private Integer size;

    // 构造方法
    public P707_MyLinkedList() {
        this.virtualHead = new ListNode(-1);
        this.size = 0;
    }

    // 获取索引位置的值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current = virtualHead;
        while (index >= 0) {
            current = current.next;
            index--;
        }
        return current.val;
    }

    // 插入头节点
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = virtualHead.next;
        virtualHead.next = node;
        size++;
    }

    // 插入尾节点
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode current = virtualHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }

    // 在制定位置插入节点
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        ListNode node = new ListNode(val);
        ListNode current = virtualHead;
        while (index > 0) {
            current = current.next;
            index--;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }

    // 删除指定索引位置的节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode current = virtualHead;
        while (index > 0) {
            current = current.next;
            index--;
        }
        current.next = current.next.next;
        size--;
    }
}
