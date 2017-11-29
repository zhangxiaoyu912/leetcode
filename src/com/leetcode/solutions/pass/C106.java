package com.leetcode.solutions.pass;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class C106 {
    
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null)
            return null;

        if (postorder.length == 0 || inorder.length == 0)
            return null;

        int length = postorder.length;
        if (length == 1) {
            TreeNode node = new TreeNode(postorder[0]);
            node.right = null;
            node.left = null;
            return node;
        }

        if (length == 2) {
            TreeNode node = new TreeNode(postorder[1]);
            if (postorder[0] == inorder[0]) {
                node.left = new TreeNode(postorder[0]);
                node.right = null;
            } else {
                node.right = new TreeNode(postorder[0]);
                node.left = null;
            }
            return node;
        }

        int current = postorder[length - 1];
        TreeNode node = new TreeNode(current);
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
            int[] postorderLeft = new int[j];
            System.arraycopy(inorder, 0, inorderLeft, 0, j);
            System.arraycopy(postorder, 0, postorderLeft, 0, j);
            leftNode = buildTree(inorderLeft, postorderLeft);
        }

        // get inorder right
        // get preorder right
        TreeNode rightNode;
        if (length - j - 1 == 0) {
            rightNode = null;
        } else {
            int[] inorderRight = new int[length - j - 1];
            int[] postorderRight = new int[length - j - 1];
            System.arraycopy(inorder, j + 1, inorderRight, 0, length - j - 1);
            System.arraycopy(postorder, j, postorderRight, 0, length - j - 1);
            rightNode = buildTree(inorderRight, postorderRight);
        }

        node.left = leftNode;
        node.right = rightNode;

        return node;
    }
}
