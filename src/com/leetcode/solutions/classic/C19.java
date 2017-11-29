package com.leetcode.solutions.classic;

public class C19 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i=1; i<=n+1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] strings) {
        C19 c = new C19();
        ListNode root = new C19.ListNode(1);
        root.next = new C19.ListNode(2);
//        root.next.next = new C19.ListNode(3);
//        root.next.next.next = new C19.ListNode(4);
//        root.next.next.next.next = new C19.ListNode(5);
        ListNode node = c.removeNthFromEnd(root, 1);
        System.out.println(node);
    }
}
