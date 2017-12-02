package com.leetcode.solutions.pass;

public class C64 {
    // similar as 62, 63, mark the cost from destination to source
    // a better improvement might be mark it in place of 'grid'
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i --)
            res[i][n - 1] = grid[i][n - 1] + res[i + 1][n - 1];
        for (int j = n - 2; j >= 0; j --)
            res[m - 1][j] = grid[m - 1][j] + res[m - 1][j + 1];

        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                res[i][j] = Math.min(res[i + 1][j], res[i][j + 1]) + grid[i][j];
            }
        }

        return res[0][0];
    }
}
