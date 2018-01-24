package com.leetcode.solutions.linkedlist;

public class C24_swap_nodes_in_pairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null && node.next != null && node.next.next != null) {
            ListNode temp1 = node.next;
            ListNode temp2 = node.next.next;
            ListNode temp3 = node.next.next.next;
            node.next = temp2;
            node.next.next = temp1;
            node.next.next.next = temp3;

            node = node.next.next;
        }

        return dummy.next;
    }
}
