package com.leetcode.solutions.pass;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class C106 {
    
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    // better solution is https://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/
    // similar as C105
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;

        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }

        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);

        //find parent element index from inorder
        int k=0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                k=i;
                break;
            }
        }

        p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
        p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);

        return p;
    }

    // my solution also works, but not neat
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (postorder == null || inorder == null)
//            return null;
//
//        if (postorder.length == 0 || inorder.length == 0)
//            return null;
//
//        int length = postorder.length;
//        if (length == 1) {
//            TreeNode node = new TreeNode(postorder[0]);
//            node.right = null;
//            node.left = null;
//            return node;
//        }
//
//        if (length == 2) {
//            TreeNode node = new TreeNode(postorder[1]);
//            if (postorder[0] == inorder[0]) {
//                node.left = new TreeNode(postorder[0]);
//                node.right = null;
//            } else {
//                node.right = new TreeNode(postorder[0]);
//                node.left = null;
//            }
//            return node;
//        }
//
//        int current = postorder[length - 1];
//        TreeNode node = new TreeNode(current);
//        int j;
//        for (j = 0; j < inorder.length; j ++) {
//            if (inorder[j] == current)
//                break;
//        }
//
//        // get inorder left
//        // get preorder left
//        TreeNode leftNode;
//        if (j == 0) {
//            leftNode = null;
//        } else {
//            int[] inorderLeft = new int[j];
//            int[] postorderLeft = new int[j];
//            System.arraycopy(inorder, 0, inorderLeft, 0, j);
//            System.arraycopy(postorder, 0, postorderLeft, 0, j);
//            leftNode = buildTree(inorderLeft, postorderLeft);
//        }
//
//        // get inorder right
//        // get preorder right
//        TreeNode rightNode;
//        if (length - j - 1 == 0) {
//            rightNode = null;
//        } else {
//            int[] inorderRight = new int[length - j - 1];
//            int[] postorderRight = new int[length - j - 1];
//            System.arraycopy(inorder, j + 1, inorderRight, 0, length - j - 1);
//            System.arraycopy(postorder, j, postorderRight, 0, length - j - 1);
//            rightNode = buildTree(inorderRight, postorderRight);
//        }
//
//        node.left = leftNode;
//        node.right = rightNode;
//
//        return node;
//    }
}
