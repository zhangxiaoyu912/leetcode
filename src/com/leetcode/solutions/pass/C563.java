package com.leetcode.solutions.pass;

public class C563 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;

        int left = 0;
        int right = 0;
        int leftVal = 0;
        int rightVal = 0;

        if (root.left != null) {
            left = findTilt(root.left);
            leftVal = treeValue(root.left);
        }

        if (root.right != null) {
            right = findTilt(root.right);
            rightVal = treeValue(root.right);
        }

        return Math.abs(leftVal - rightVal) + left + right;
    }

    private int treeValue(TreeNode node) {
        if (node == null)
            return 0;

        int val = node.val;
        if (node.left != null)
            val += treeValue(node.left);

        if (node.right != null)
            val += treeValue(node.right);

        return val;
    }
}
