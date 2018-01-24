package com.leetcode.solutions.linkedlist;

public class C21_merge_two_sorted_list {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null || l2 != null) {
            if (l2 == null) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1 == null) {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else { // l2.val < l1.val
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            node = node.next;
        }

        return dummy.next;
    }

    public static void main(String[] strings) {
//        ListNode l1 = new C21_merge_two_sorted_list.ListNode(1);
//        l1.next = new C21_merge_two_sorted_list.ListNode(2);
//        l1.next.next = new C21_merge_two_sorted_list.ListNode(4);
//
//        ListNode l2 = new C21_merge_two_sorted_list.ListNode(1);
//        l2.next = new C21_merge_two_sorted_list.ListNode(3);
//        l2.next.next = new C21_merge_two_sorted_list.ListNode(4);
//
//        C21_merge_two_sorted_list c = new C21_merge_two_sorted_list();
//        ListNode res = c.mergeTwoLists(l1, l2);
//        System.out.println(res);
        int i = 5;
        Integer j = 5;
        System.out.println(i == j);
    }
}
