package com.leetcode.solutions.classic;

/**
 *
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 */

public class C101 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        // solution 1: recursively
        if (root == null || (root.left == null && root.right == null))
            return true;

        return isSymmetric(root.left, root.right);
    }

    // this is also a format of similar problems
    // the value comparision is the key, if one of null and another is not, value will not be equal
    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (r == null || l == null) {
            return false;
        }

        if (l.val != r.val)
            return false;

        if (!isSymmetric(l.left, r.right))
            return false;
        if (!isSymmetric(l.right, r.left))
            return false;

        return true;
    }

    // using stack is not needed !!!!!

//    private boolean isSymmetric(TreeNode left, TreeNode right) {
//        Stack<TreeNode> stack1 = new Stack();
//        Stack<TreeNode> stack2 = new Stack();
//
//        stack1.push(left);
//        stack2.push(right);
//        while (!stack1.isEmpty() && !stack2.isEmpty()) {
//            TreeNode cuLeft = stack1.pop();
//            TreeNode cuRight = stack2.pop();
//            if ((cuLeft == null) != (cuRight == null))
//                return false;
//
//            if (((cuLeft.left == null) != (cuRight.right == null)) ||
//                    (cuLeft.right == null) != (cuRight.left == null))
//                return false;
//
//            if ((cuLeft.left == null && cuRight.left == null) &&
//                    cuLeft.right == null && cuRight.right == null)
//                return cuLeft.val == cuRight.val;
//
//            if (cuLeft.left != null && cuRight.right != null) {
//                stack1.push(cuLeft.left);
//                stack2.push(cuRight.right);
//            }
//
//            if (cuLeft.right != null && cuRight.left != null) {
//                stack1.push(cuLeft.right);
//                stack2.push(cuRight.left);
//            }
//        }
//
//        return stack1.isEmpty() == stack2.isEmpty();
//    }

    public static void main(String[] strings) {
        C101 c = new C101();
        TreeNode root = new C101.TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(c.isSymmetric(root));
    }

}
