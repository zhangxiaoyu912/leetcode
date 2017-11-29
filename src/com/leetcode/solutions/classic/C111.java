package com.leetcode.solutions.classic;

/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

public class C111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if (l == 0 && r != 0)
            return r + 1;
        if (l != 0 && r == 0)
            return l + 1;

        return Math.min(l, r) + 1;
    }

}
