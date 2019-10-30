package com.leetcode.solutions.pass;

public class C63_unique_path_2 {

    /*
    Solution 1: use 1 d array to memorize the result
    This is a typical 2D DP problem, we can store value in 2D DP array,
    but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] to update dp[i][j],
    we don't need to store the whole 2D table, but instead store value in an 1D array,
    and update data by using dp[j] = dp[j] + dp[j - 1],
    (where here dp[j] corresponding to the dp[i - 1][j]) and dp[j - 1] corresponding to the dp[i][j - 1] in the 2D array)
    fixme: the trick is just use 1 dimension, but keep updating it (only add), hence dp[j - 1] comes from left, previous row's value in place present comes from up
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    /*
    Solution 2: use 2 d array to remember, but it is easier to understand
     */
    public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
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
        C63_unique_path_2 c = new C63_unique_path_2();
        int[] num1 = new int[]{0, 0};
        int[] num2 = new int[]{0, 0};
        int[][] nums = new int[][]{num1, num2};
        System.out.println(c.uniquePathsWithObstacles(nums));
    }
}
