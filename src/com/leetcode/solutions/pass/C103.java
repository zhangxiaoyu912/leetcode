package com.leetcode.solutions.pass;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class C103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return new ArrayList<>();
        stack.add(root);

        boolean left = true;
        while (!stack.isEmpty()) {
            // pop num TreeNode
            List<TreeNode> nodes = new ArrayList<>();
            while (!stack.isEmpty())
                nodes.add(stack.pop());

            // put their children into queue
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : nodes) {
                // fill the list
                list.add(node.val);
                if (left) {
                    if (node.left != null)
                        stack.push(node.left);
                    if (node.right != null)
                        stack.push(node.right);
                } else {
                    if (node.right != null)
                        stack.push(node.right);
                    if (node.left != null)
                        stack.push(node.left);
                }
            }

            left ^= true;
            results.add(list);
        }

        return results;
    }

    public static void main(String[] args) {

    }
}
