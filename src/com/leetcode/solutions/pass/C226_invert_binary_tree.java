package com.leetcode.solutions.pass;

public class C226_invert_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
