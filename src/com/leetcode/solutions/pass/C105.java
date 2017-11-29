package com.leetcode.solutions.pass;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class C105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;

        if (preorder.length == 0 || inorder.length == 0)
            return null;

        int length = preorder.length;
        if (length == 1) {
            TreeNode node = new TreeNode(preorder[0]);
            node.right = null;
            node.left = null;
            return node;
        }

        if (length == 2) {
            TreeNode node = new TreeNode(preorder[0]);
            if (preorder[0] == inorder[0]) {
                node.right = new TreeNode(preorder[1]);
                node.left = null;
            } else {
                node.left = new TreeNode(preorder[1]);
                node.right = null;
            }
            return node;
        }

        TreeNode node = new TreeNode(preorder[0]);
        int current = preorder[0];
        int j;
        for (j = 0; j < inorder.length; j ++) {
            if (inorder[j] == current)
                break;
        }

        // get inorder left
        // get preorder left
        TreeNode leftNode;
        if (j == 0) {
            leftNode = null;
        } else {
            int[] inorderLeft = new int[j];
            int[] preorderLeft = new int[j];
            System.arraycopy(inorder, 0, inorderLeft, 0, j);
            System.arraycopy(preorder, 1, preorderLeft, 0, j);
            leftNode = buildTree(preorderLeft, inorderLeft);
        }

        // get inorder right
        // get preorder right
        TreeNode rightNode;
        if (length - j - 1 == 0) {
            rightNode = null;
        } else {
            int[] inorderRight = new int[length - j - 1];
            int[] preorderRight = new int[length - j - 1];
            System.arraycopy(inorder, j + 1, inorderRight, 0, length - j - 1);
            System.arraycopy(preorder, j + 1, preorderRight, 0, length - j - 1);
            rightNode = buildTree(preorderRight, inorderRight);
        }

        node.left = leftNode;
        node.right = rightNode;

        return node;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2};
        int[] in = new int[]{2, 1};
        C105 c = new C105();
        TreeNode node = c.buildTree(pre, in);
        System.out.println(node);
    }
}
