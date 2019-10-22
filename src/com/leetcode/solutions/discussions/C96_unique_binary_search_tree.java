package com.leetcode.solutions.discussions;

public class C96_unique_binary_search_tree {

    // think the the left tree and right tree 's shape will change independently, hence it will the sum of them
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;// if no node, root==null, still 1 combination
        count[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 0; j < i; j ++)
                count[i] += count[j] * count[i - j - 1];
        }

        return count[n];// so count[n] actually means there are n nodes
    }
}
