package com.leetcode.solutions.pass;

public class C566_reshape_the_matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0)
            return nums;

        int m = nums.length;
        int n = nums[0].length;
        if (m*n != r*c)
            return nums;

        if (c == n && r == m)
            return nums;

        int[][] res = new int[r][c];
        int i = 0;
        while (i < r*c) {
            res[i/c][i%c] = nums[i/n][i%n];
            i++;
        }

        return res;
    }
}
