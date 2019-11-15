package com.leetcode.solutions.classic;

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
public class C102_Binary_Tree_Level_Order_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    Solution 1: neat code, not using a queue, but DFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

    /*
    Solution 2, using a queue, BFS, lengthy to write on whiteboard
     */
    // change list to queue will be better, for each level holding
    // so there will be only two queues, one of entire traverse, one for each level
    public List<List<Integer>> levelOrder_2(TreeNode root) {
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
