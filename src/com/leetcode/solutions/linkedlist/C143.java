package com.leetcode.solutions.linkedlist;

/**
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class C143 {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // split
        ListNode slow = head;
        ListNode fast = head;
        // this line is important to make sure fast traverse twice speed as slow
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse : this is very important
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode current = second;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second = prev;

        // merge, this is tricky and need to revisit it
        ListNode p1 = head;
        ListNode p2 = second;
        while (p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
        }


        // this solution is too long and doesn't work (doesn't update the head , and traverse one more time)
//
//        // split
//        int length = 1;
//        ListNode node = head;
//        while (node.next != null) {
//            length += 1;
//            node = node.next;
//        }
//        int half = length / 2;
//        ListNode left = new ListNode(head.val);
//        ListNode leftHead = left;
//        int index = 0;
//        while (index < half - 1) {
//            head = head.next;
//            ListNode newNode = new ListNode(head.val);
//            left.next = newNode;
//            left = left.next;
//            index += 1;
//        }
//
//        head = head.next;
//        ListNode right = new ListNode(head.val);
//        ListNode rightHead = right;
//        while (index < length - 2) {
//            head = head.next;
//            ListNode newNode = new ListNode(head.val);
//            right.next = newNode;
//            right = right.next;
//            index += 1;
//        }
//
//        // reverse the rightHead
//        ListNode prev = null;
//        ListNode current = rightHead;
//        ListNode next = null;
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        rightHead = prev;
//
//        // merge
//        head = new ListNode(leftHead.val);
////        head = res;
//        leftHead = leftHead.next;
//        boolean leftIns = false;
//        while (leftHead != null || rightHead != null) {
//            if (leftIns) {
//                ListNode temp = new ListNode(leftHead.val);
//                head.next = temp;
//                head = head.next;
//                leftHead = leftHead.next;
//                leftIns = false;
//            } else {
//                ListNode temp = new ListNode(rightHead.val);
//                head.next = temp;
//                head = head.next;
//                rightHead = rightHead.next;
//                leftIns = true;
//            }
//        }
    }

    public static void main(String[] strings) {
        C143 c = new C143();
        ListNode root = new C143.ListNode(1);
        root.next = new C143.ListNode(2);
        root.next.next = new C143.ListNode(3);
        root.next.next.next = new C143.ListNode(4);
        c.reorderList(root);
        System.out.println(root);
    }
}
