package com.leetcode.solutions.pass;

import java.util.ArrayDeque;
import java.util.Queue;

public class C100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;

        Queue<TreeNode> q1 = new ArrayDeque();
        Queue<TreeNode> q2 = new ArrayDeque();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1.val != node2.val)
                return false;

            if ((node1.left == null) != (node2.left == null))
                return false;
            if ((node1.right == null) != (node2.right == null))
                return false;

            if (node1.left != null) {
                q1.add(node1.left);
                q2.add(node2.left);
            }

            if (node2.right != null) {
                q1.add(node1.right);
                q2.add(node2.right);
            }
        }

        return q1.isEmpty() == q2.isEmpty();
    }
}
