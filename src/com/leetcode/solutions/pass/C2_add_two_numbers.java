package com.leetcode.solutions.pass;

public class C2_add_two_numbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode dummy = new ListNode(1);
        ListNode node = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int value = carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            carry = value / 10;
            value = value % 10;
            node.next = new ListNode(value);
            node = node.next;
        }

        if (carry > 0)
            node.next = new ListNode(carry);

        return dummy.next;
    }
}
