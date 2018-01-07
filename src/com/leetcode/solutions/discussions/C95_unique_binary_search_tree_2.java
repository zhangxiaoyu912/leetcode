package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.List;

public class C95_unique_binary_search_tree_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);
    }

    public List<TreeNode> helper(int m, int n){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(m>n){
            result.add(null);
            return result;
        }

        for(int i=m; i<=n; i++){
            List<TreeNode> ls = helper(m, i-1);
            List<TreeNode> rs = helper(i+1, n);
            // by doing this, you can combine all possible l with all possible r
            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    result.add(curr);
                }
            }
        }

        return result;
    }

    // not really work by this route since it doesn't handle the permutation well
//     public List<TreeNode> generateTrees(int n) {
//         List<TreeNode> list = new ArrayList<>();
//         if (n == 0)
//             return list;
//         if (n == 1) {
//             list.add(new TreeNode(1));
//             return list;
//         }

//         for (int i = 2; i <= n; i ++) {
//             for (j = 1; j <= i; j ++) {
//                 TreeNode root = new TreeNode(j);
//                 root.left = genTree(i);
//                 root.right = genTree(i - j);
//                 list.add(root);
//             }
//         }

//         return list;
//     }
}
