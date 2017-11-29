package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return true;

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

        int num = list.get(0);
        for (int i = 1; i < list.size(); i ++) {
            if (list.get(i) <= num)
                return false;

            num = list.get(i);
        }

        return true;
    }
}
