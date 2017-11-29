package com.leetcode.solutions.checked.discussion;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

public class C173 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static public class BSTIterator {

        private TreeNode node;

        private final Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            if (!hasNext())
                return Integer.MIN_VALUE;

            TreeNode node = stack.pop();
            int val = node.val;
            if (node.right != null) {
              node = node.right;
              while (node != null) {
                  stack.push(node);
                  node = node.left;
              }
            }

            return val;
        }
    }

    public static void main(String[] strs) {
        BSTIterator c = new C173.BSTIterator(null);
        System.out.println(c.next());
    }
}
