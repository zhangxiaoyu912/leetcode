package com.leetcode.solutions.pass;

public class C63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] matrix = new int[m][n];
        boolean blocked = false;
        for (int i = m - 1; i >= 0; i --) {
            if (obstacleGrid[i][ n - 1] == 0 && !blocked)
                matrix[i][n - 1] = 1;
            if (obstacleGrid[i][n - 1] == 1)
                blocked = true;
        }

        blocked = false;
        for (int j = n - 1; j >= 0; j --) {
            if (obstacleGrid[m - 1][j] == 0 && !blocked)
                matrix[m - 1][j] = 1;
            if (obstacleGrid[m - 1][j] == 1)
                blocked = true;
        }

        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                if (obstacleGrid[i][j] == 1)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
            }
        }

        return matrix[0][0];
    }

    public static void main(String[] strings) {
        C63 c = new C63();
        int[] num1 = new int[]{0, 0};
        int[] num2 = new int[]{0, 0};
        int[][] nums = new int[][]{num1, num2};
        System.out.println(c.uniquePathsWithObstacles(nums));
    }
}
