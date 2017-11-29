package com.leetcode.solutions.classic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null) {
            stack.add(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);

            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    stack.add(curr);
                    curr = curr.left;
                }
            }
        }

        return list;
    }
}
