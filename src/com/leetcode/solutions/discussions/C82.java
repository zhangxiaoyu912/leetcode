package com.leetcode.solutions.discussions;

public class C82 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            // the way do this is tricky which reminds that don't have to always use a boolean var to track !!
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                // this is the most tricky part
                while (head.next != null && head.next.val == val)
                    head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
