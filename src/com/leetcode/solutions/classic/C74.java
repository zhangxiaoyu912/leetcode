package com.leetcode.solutions.classic;

public class C74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;

        int b = 0;
        int e = m - 1;
        if (target > matrix[e][0]) {
            b = e;
        } else {
            while (b < e - 1) {
                int mid = (e + b) / 2;
                if (matrix[mid][0] == target)
                    return true;
                else if (matrix[mid][0] > target)
                    e = mid;
                else
                    b = mid;

                if (matrix[e][0] == target || matrix[b][0] == target)
                    return true;
            }
        }
        if (b + 1 < m && matrix[b + 1][0] == target)
            return true;

        int p = 0;
        int q = n - 1;
        while (p < q) {
            int mid = (q + p) / 2;
            if (matrix[b][mid] == target)
                return true;
            else if (matrix[b][mid] > target)
                q = mid;
            else
                p = mid + 1;

            if (matrix[b][p] == target || matrix[b][q] == target)
                return true;
        }

        return matrix[b][p] == target;
    }

    public static void main(String[] strings) {
        C74 c = new C74();
        int[] num1 = new int[]{1};
        int[] num2 = new int[]{3};
//        int[] num3 = new int[]{23,30,34,50};
        int[][] nums = new int[][]{num1, num2};
        System.out.println(c.searchMatrix(nums, 3));
    }
}
