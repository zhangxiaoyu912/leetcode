package com.leetcode.solutions.classic;

public class C86 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lessTail = dummy;

        boolean show = false;
        while (head != null && head.next != null) {
            if (head.val >= x)
                show = true;

            if (!show && head.val < x)
                lessTail = head;

            if (head.next.val < x && show) {
                ListNode temp = head.next.next;
                head.next.next = lessTail.next;
                lessTail.next = head.next;
                head.next = temp;
                lessTail = lessTail.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] strings) {
        C86 c = new C86();
        ListNode head = new C86.ListNode(1);
        head.next = new C86.ListNode(4);
        head.next.next = new C86.ListNode(3);
        head.next.next.next = new C86.ListNode(2);
        head.next.next.next.next = new C86.ListNode(5);
        head.next.next.next.next.next = new C86.ListNode(2);

        ListNode res = c.partition(head, 2);
        System.out.println(res);
    }
}
