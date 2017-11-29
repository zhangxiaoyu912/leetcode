package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class C73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> setM = new HashSet<>();
        Set<Integer> setN = new HashSet<>();

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] != 0)
                    continue;
                else {
                    setM.add(i);
                    setN.add(j);
                }
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (setM.contains(i) || setN.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
