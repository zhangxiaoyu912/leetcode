package com.leetcode.solutions.pass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */

public class C199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> temp = new ArrayList<>();
        TreeNode node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty())
                temp.add(queue.poll());

            list.add(temp.get(temp.size() - 1).val);
            for (TreeNode tempNode : temp) {
                if (tempNode.left != null)
                    queue.add(tempNode.left);
                if (tempNode.right != null)
                    queue.add(tempNode.right);
            }
            temp = new ArrayList<>();
        }

        return list;
    }

}
