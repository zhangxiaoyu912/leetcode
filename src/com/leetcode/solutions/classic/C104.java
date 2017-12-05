package com.leetcode.solutions.classic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class C104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // this is the most neat solution, use no additional data structure
    // it also can serve as a template for similar problems
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger+1;
    }

    // this solution is OK, but
    // need to the BFS since need to traverse everything anyway and this is much easier to handle
//    public int maxDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        int count = 0;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            List<TreeNode> list = new ArrayList<>();
//            while (!queue.isEmpty())
//                list.add(queue.poll());
//            count += 1;
//
//            for (TreeNode node : list) {
//                if (node.left != null)
//                    queue.add(node.left);
//                if (node.right != null)
//                    queue.add(node.right);
//            }
//        }
//
//        return count;
//    }
}
