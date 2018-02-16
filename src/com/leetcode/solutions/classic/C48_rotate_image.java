package com.leetcode.solutions.classic;

public class C48_rotate_image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // it looks like hard at beginning, but think like divide matrix into 4 part :
        // rotate upper left to upper right,
        // upper right to lower right,
        // lower right to lower left,
        // lower left to upper left
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
