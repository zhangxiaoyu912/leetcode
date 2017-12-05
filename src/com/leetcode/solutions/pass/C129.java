package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class C129 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // much neat code by classic structure
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        return dfs(root, 0, 0);
    }

    public int dfs(TreeNode node, int num, int sum){
        if(node == null) return sum;

        num = num*10 + node.val;

        // leaf
        if(node.left == null && node.right == null) {
            sum += num;
            return sum;
        }

        // left subtree + right subtree
        sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
        return sum;
    }

    // my solution, also works
//    public int sumNumbers(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        if (root.left == null && root.right == null)
//            return root.val;
//
//        int sum = 0;
//        Stack<TreeNode> stack = new Stack<>();
//        List<TreeNode> list = new ArrayList<>();
//        stack.push(root);
//        while(!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//
//            if (!list.isEmpty()) {
//                for (int i = list.size() - 1; i >= 0; i --) {
//                    if (isParent(list.get(i), node))
//                        break;
//                    else
//                        list.remove(i);
//                }
//            }
//
//            if (isLeaf(node)) {
//                int temp = 0;
//                for (TreeNode tempNode: list) {
//                    temp = temp * 10 + tempNode.val;
//                }
//                temp = temp * 10 + node.val;
//                sum += temp;
//            } else {
//                list.add(node);
//            }
//
//            if (node.right != null)
//                stack.push(node.right);
//            if (node.left != null)
//                stack.push(node.left);
//        }
//
//        return sum;
//    }
//
//    private boolean isLeaf(TreeNode node) {
//        return node.left == null && node.right == null;
//    }
//
//    private boolean isParent(TreeNode node1, TreeNode node2) {
//        return node1.left == node2 || node1.right == node2;
//    }

    public static void main(String[] strings) {
        C129 c = new C129();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = null;
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        int sum = c.sumNumbers(root);
        System.out.println(sum);
    }
}
