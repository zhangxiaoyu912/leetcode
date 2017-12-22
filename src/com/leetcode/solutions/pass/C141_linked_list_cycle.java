package com.leetcode.solutions.pass;

public class C141_linked_list_cycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast.val == slow.val)
                return true;

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
