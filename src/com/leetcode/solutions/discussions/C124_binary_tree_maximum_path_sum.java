package com.leetcode.solutions.discussions;

public class C124_binary_tree_maximum_path_sum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public int calculateSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;

        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

        return current;
    }
    // public int maxPathSum(TreeNode root) {
    //     if (root.left == null && root.right == null) {
    //         return root.val;
    //     } else if (root.left == null) {
    //         int right = maxPathSum(root.right);
    //         int max1 = Math.max(right, right + root.val);
    //         int max2 = Math.max(max1, root.val);
    //         return max2;
    //     } else if (root.right == null) {
    //         int left = maxPathSum(root.left);
    //         int max1 = Math.max(left, left + root.val);
    //         int max2 = Math.max(max1, root.val);
    //         return max2;
    //     } else {
    //         int right = maxPathSum(root.right);
    //         int left = maxPathSum(root.left);
    //         int maxChild = Math.max(right, left);
    //         // max path is the max of (1) root only (2) root + left (3) root + right (4) left only (5) right only
    //         int max1 = Math.max(maxChild, root.val);
    //         int max2 = Math.max(max1, root.val + left);
    //         int max3 = Math.max(max2, root.val + right);
    //         int max4 = Math.max(max3, root.val + left + right);
    //         return max4;
    //     }
    // }
}
