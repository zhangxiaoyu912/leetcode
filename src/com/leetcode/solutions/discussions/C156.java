package com.leetcode.solutions.discussions;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
 1
 / \
 2   3
 / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5   2
 / \
 3   1
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


 OJ's Binary Tree Serialization:
 The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

 Here's an example:
 1
 / \
 2   3
 /
 4
 \
 5
 The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class C156 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode node = root;
        TreeNode parent = null;
        TreeNode right = null;
        while (node.left != null) {
            // this solution is tricky
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }

        return node;

        // this solution takes too long, it takes more JVM stack
//        if (root == null)
//            return null;
//
//        TreeNode node = root;
//        TreeNode left = node.left;
//        TreeNode right = node.right;
//        while(left != null) {
//            left.right = node;
//            left.left = right;
//            left = upsideDownBinaryTree(left);
//            return left;
//        }
//
//        return node;
    }
}
