package com.leetcode.solutions.linkedlist;

public class C237_delete_node_in_a_linked_list {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
        } else {
            while (node != null && node.next != null) {
                node.val = node.next.val;
                if (node.next.next == null)
                    node.next = null;
                else
                    node = node.next;
            }
        }
    }
}
