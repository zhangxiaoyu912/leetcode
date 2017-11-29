package com.leetcode.solutions.pass;

/**
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */
public class C114 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;

        if (root.left != null && !isLeaf(root.left))
            flatten(root.left);

        if (root.right != null && !isLeaf(root.right))
            flatten(root.right);

        if (root.left != null) {
            TreeNode leftPointer = root.left;
            while (leftPointer.right != null) {
                leftPointer.left = null;
                leftPointer = leftPointer.right;
            }

            leftPointer.right = root.right;
            leftPointer.left = null;
            root.right = root.left;
            root.left = null;
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        C114 c = new C114();
        TreeNode node = new C114.TreeNode(1);
        node.left = null;
        node.right = new C114.TreeNode(2);
        node.right.left = new C114.TreeNode(3);
        node.right.right = null;

        c.flatten(node);

        System.out.println(node);
    }
}
