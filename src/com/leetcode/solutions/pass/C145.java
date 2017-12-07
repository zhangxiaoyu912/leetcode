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

    // Among preoder, inorder and postorder binary tree traversal problems, postorder traversal is the most complicated one.

    // 1st solution :
    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode curr = stack.peek();

            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }

                //go up the tree from left node
                //need to check if there is a right child
                //if yes, push it to stack
                //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }

                //go up the tree from right node
                //after coming back from right node, process parent node and pop stack.
            }else if(curr.right == prev){
                stack.pop();
                lst.add(curr.val);
            }

            prev = curr;
        }

        return lst;
    }

    // 2nd solution :
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//
//        if(root==null) {
//            return res;
//        }
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//
//        while(!stack.isEmpty()) {
//            TreeNode temp = stack.peek();
//            if(temp.left==null && temp.right==null) {
//                TreeNode pop = stack.pop();
//                res.add(pop.val);
//            }
//            else {
//                if(temp.right!=null) {
//                    stack.push(temp.right);
//                    temp.right = null;
//                }
//
//                if(temp.left!=null) {
//                    stack.push(temp.left);
//                    temp.left = null;
//                }
//            }
//        }
//
//        return res;
//    }

    // this is my recursive solution, work but not most desired
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null)
//            return list;
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        add(stack, list);
//
//        return list;
//    }
//
//    private void add(Stack<TreeNode> stack, List<Integer> list) {
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//
//            if (node.left != null) {
//                stack.push(node.left);
//                add(stack, list);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//                add(stack, list);
//            }
//
//            list.add(node.val);
//        }
//    }

}
