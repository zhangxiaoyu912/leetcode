package com.leetcode.solutions.checked.discussion;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class C112 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && (root.left == null && root.right == null))
            return true;

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null)
//            return false;
//
//        if (root.val == sum && (root.left != null || root.right != null))
//            return false;
//
//        return hasSum(root, sum);
//    }
//
//    private boolean hasSum(TreeNode node, int sum) {
//        if (node == null)
//            return sum == 0;
//
//        boolean left = hasSum(node.left, sum - node.val);
//        boolean right = hasSum(node.right, sum - node.val);
//
//        return left || right;
//    }

    public static void main(String[] strings) {
        C112 c = new C112();
        TreeNode node = new C112.TreeNode(1);
//        node.right = new C112.TreeNode(2);
        System.out.println(c.hasPathSum(node, 1));
    }

}
