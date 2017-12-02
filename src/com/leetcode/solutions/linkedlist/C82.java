package com.leetcode.solutions.linkedlist;

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

        // if use two pointers, should also work, it just code cannot be this simple
        // but the share logic of using one point and two pointers are :
        // in case of duplicate, use an additional while loop to delete all the duplicate nodes including starting point
        while (head.next != null && head.next.next != null) {
            // the way do this is tricky which reminds that don't have to always use a boolean var to track !!
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                // this is the most tricky part
                // this while loop also delete the first 'duplicate' node, since the val is extracted in advance
                while (head.next != null && head.next.val == val)
                    head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
