package com.leetcode.solutions.pass;

public class C61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length += 1;
            node = node.next;
        }

        k = k >= length ? k % length : k;
        if (k == 0)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && k > 0) {
            k --;
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
