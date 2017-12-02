package com.leetcode.solutions.linkedlist;

public class C83 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node = head;
        ListNode next = head.next;

        while (next != null) {
            if (next.val == node.val) {
                node.next = next.next;
                if (next.next == null)
                    break;
                else
                    next = next.next;
            } else {
                node = next;
                next = next.next;
            }
        }

        return head;
    }

    public static void main(String[] strings) {
        C83 c = new C83();
        ListNode root = new C83.ListNode(1);
        root.next = new C83.ListNode(1);
        root.next.next = new C83.ListNode(2);
        ListNode res = c.deleteDuplicates(root);
        System.out.println(res);
    }
}
