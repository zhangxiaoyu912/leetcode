package com.leetcode.solutions.discussions;

/**
 *
 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */
public class C142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return null;

            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
