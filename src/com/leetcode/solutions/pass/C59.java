package com.leetcode.solutions.pass;

public class C59 {
    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return new int[][]{};

        int[][] matrix = new int[n][n];

        int xL = 0;
        int xR = n - 1;
        int yL = 0;
        int yR = n - 1;

        spiralOrder(1, matrix, xL, xR, yL, yR);
        return matrix;
    }

    private void spiralOrder(int num, int[][] matrix, int xL, int xR, int yL, int yR) {
        if (xL > xR && yL > yR)
            return;

        if (xL == xR && yL == yR) {
            matrix[xL][yL] = num ++;
        } else if (xL < xR && yL < yR) {
            for (int j = yL; j < yR; j++)
                matrix[xL][j] = num ++;

            for (int i = xL; i < xR; i++)
                matrix[i][yR] = num ++;

            for (int j = yR; j > yL; j--)
                matrix[xR][j] = num ++;

            for (int i = xR; i > xL; i--)
                matrix[i][yL] = num ++;
        } else if (xL < xR && yL == yR) {
            for (int i = xL; i <= xR; i ++)
                matrix[i][yL] = num ++;
        } else if (xL == xR && yL < yR) {
            for (int j = yL; j <= yR; j ++)
                matrix[xL][j] = num ++;
        }

        xL ++;
        xR --;
        yL ++;
        yR --;

        spiralOrder(num, matrix, xL, xR, yL, yR);
    }

    public static void main(String[] strings) {
        C59 c = new C59();
        int[][] matrix = c.generateMatrix(3);
        System.out.println(matrix);
    }
}
