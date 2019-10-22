package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class C113_path_sum_2 {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        // !!! always make sure root got in first
        List<Integer> level = new ArrayList<>();
        level.add(root.val);
        pathSum(root, sum - root.val, level, list);

        return list;
    }

    private void pathSum(TreeNode node, int sum, List<Integer> level, List<List<Integer>> list) {
        if (sum == 0 && (node.left == null && node.right == null)) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(level);
            list.add(copy);
            // no return here
        }


        if (node.left != null) {
            level.add(Integer.valueOf(node.left.val));
            pathSum(node.left, sum - node.left.val, level, list);
            level.remove(level.size() - 1);
        }

        if (node.right != null) {
            level.add(Integer.valueOf(node.right.val));
            pathSum(node.right, sum - node.right.val, level, list);
            level.remove(level.size() - 1);
        }
    }

    public static void main(String[] strings) {
        C113_path_sum_2 c = new C113_path_sum_2();
        C113_path_sum_2.TreeNode node = new C113_path_sum_2.TreeNode(5);
        node.left = new C113_path_sum_2.TreeNode(4);
        node.right = new C113_path_sum_2.TreeNode(8);
        node.left.left = new C113_path_sum_2.TreeNode(11);
        node.left.left.left = new C113_path_sum_2.TreeNode(7);
        node.left.left.right = new C113_path_sum_2.TreeNode(2);
        node.right.left = new C113_path_sum_2.TreeNode(13);
        node.right.right = new C113_path_sum_2.TreeNode(4);
        node.right.right.right = new C113_path_sum_2.TreeNode(1);
        node.right.right.left = new C113_path_sum_2.TreeNode(5);
        List<List<Integer>> list = c.pathSum(node, 22);
        for (List<Integer> level : list) {
            System.out.println("==============");
            for (int num : level)
                System.out.print(num + " ");
        }
    }
}
