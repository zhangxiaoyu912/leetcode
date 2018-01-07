package com.leetcode.solutions.classic;

public class C99_recover_binary_search_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode first;
    TreeNode second;
    TreeNode pre;

    // Inorder traveral will return values in an increasing order.
    // So if an element is less than its previous element,the previous element is a swapped node.
    public void inorder(TreeNode root){
        if(root==null)
            return;

        inorder(root.left);

        if(pre==null){
            pre=root;
        }else{
            // this situation only happen once (only two elements swapped)
            if(root.val<pre.val){
                if(first==null){
                    first=pre;
                }

                second=root;
            }
            pre=root;
        }

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        if(root==null)
            return;

        inorder(root);
        // because there is ONLY two elements swapped, hence the recover opt only happen once below
        if(second!=null && first !=null){
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }

    }
}
