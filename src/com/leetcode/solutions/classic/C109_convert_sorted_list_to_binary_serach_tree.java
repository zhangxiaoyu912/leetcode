package com.leetcode.solutions.classic;

public class C109_convert_sorted_list_to_binary_serach_tree {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return new TreeNode(head.val);
        else if (head.next != null && head.next.next == null) {
            TreeNode root = new TreeNode(head.next.val);
            root.left = new TreeNode(head.val);
            return root;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode midNode = slow.next;
        slow.next = null;

        TreeNode root = new TreeNode(midNode.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);

        return root;
    }

    public static void main(String[] strings) {
        C109_convert_sorted_list_to_binary_serach_tree c = new C109_convert_sorted_list_to_binary_serach_tree();
        ListNode head = new C109_convert_sorted_list_to_binary_serach_tree.ListNode(-10);
        head.next = new C109_convert_sorted_list_to_binary_serach_tree.ListNode(-3);
        head.next.next = new C109_convert_sorted_list_to_binary_serach_tree.ListNode(0);
        head.next.next.next = new C109_convert_sorted_list_to_binary_serach_tree.ListNode(5);
        head.next.next.next.next = new C109_convert_sorted_list_to_binary_serach_tree.ListNode(9);
        TreeNode node = c.sortedListToBST(head);
        System.out.println(node);
    }
}
