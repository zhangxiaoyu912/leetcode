package com.leetcode.solutions.pass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */

public class C107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> levelNode = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                levelNode.add(temp);
            }

            list.add(0, level);
            for (TreeNode nodeL : levelNode) {
                if (nodeL.left != null)
                    queue.add(nodeL.left);
                if (nodeL.right != null)
                    queue.add(nodeL.right);
            }
        }

        return list;
    }
}
