package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 */
public class C145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        add(stack, list);

        return list;
    }

    private void add(Stack<TreeNode> stack, List<Integer> list) {
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                stack.push(node.left);
                add(stack, list);
            }
            if (node.right != null) {
                stack.push(node.right);
                add(stack, list);
            }

            list.add(node.val);
        }
    }

}
