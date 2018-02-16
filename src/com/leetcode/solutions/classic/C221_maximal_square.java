package com.leetcode.solutions.classic;

public class C221_maximal_square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == '0')
                    continue;
                else
                    max = Math.max(max, squ(matrix, i, j));
            }
        }

        return max;
    }

    private int squ(char[][] matrix, int i, int j) {
        int dim = 1;
        while(i + dim - 1 < matrix.length && j + dim - 1 < matrix[0].length) {

            if (matrix[i + dim - 1][j] == '1') {
                for (int p = i; p < i + dim; p ++) {
                    for (int q = j; q < j + dim; q ++) {
                        if (matrix[p][q] == '0') {
                            dim --;
                            return dim * dim;
                        }
                    }
                }
                dim ++;
            } else {
                break;
            }
        }

        dim --;
        return dim * dim;
    }

    public static void main(String[] strings) {
        C221_maximal_square c = new C221_maximal_square();
//        char[][] m = new char[][]{{'1', '0'}, {'1', '0'}};
        char[][] m = new char[][]{{'1','0','1','0','0'},
                                  {'1','0','1','1','1'},
                                  {'1','1','1','1','1'},
                                  {'1','0','0','1','0'}};
        System.out.println(c.maximalSquare(m));
    }
}
