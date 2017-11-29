package com.leetcode.solutions.discussions;

/**
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class C110 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // to get the height of a BT, this is classic
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int height = getHeight(root);

        return height != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if (Math.abs(left - right) > 1)
            return -1;

        if (left == -1 || right == -1)
            return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] strings) {
        C110 c = new C110();
        TreeNode root = new C110.TreeNode(1);
        root.right = new C110.TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(c.isBalanced(root));
    }
}
