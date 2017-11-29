package com.leetcode.solutions.pass;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class C102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null)
            return new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // pop num TreeNode
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty())
                nodes.add(queue.remove());

            // put their children into queue
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : nodes) {
                // fill the list
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            results.add(list);
        }

        return results;
    }

    public static void main(String[] args) {

    }
}
