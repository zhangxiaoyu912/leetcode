package com.leetcode.solutions.classic;

public class C74 {

    // this is much better code to understand
    // You may try to solve this problem by finding the row first and then the column. There is no need to do that.
    // Because of the matrix's special features, the matrix can be considered as a sorted array
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while(start<=end){
            int mid=(start+end)/2;
            // get x and y position after get mid
            int midX=mid/n;
            int midY=mid%n;

            if(matrix[midX][midY]==target)
                return true;

            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return false;
    }

    // this solution is hard to maintain and understand
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return false;
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
//            return false;
//
//        int b = 0;
//        int e = m - 1;
//        if (target > matrix[e][0]) {
//            b = e;
//        } else {
//            while (b < e - 1) {
//                int mid = (e + b) / 2;
//                if (matrix[mid][0] == target)
//                    return true;
//                else if (matrix[mid][0] > target)
//                    e = mid;
//                else
//                    b = mid;
//
//                if (matrix[e][0] == target || matrix[b][0] == target)
//                    return true;
//            }
//        }
//        if (b + 1 < m && matrix[b + 1][0] == target)
//            return true;
//
//        int p = 0;
//        int q = n - 1;
//        while (p < q) {
//            int mid = (q + p) / 2;
//            if (matrix[b][mid] == target)
//                return true;
//            else if (matrix[b][mid] > target)
//                q = mid;
//            else
//                p = mid + 1;
//
//            if (matrix[b][p] == target || matrix[b][q] == target)
//                return true;
//        }
//
//        return matrix[b][p] == target;
//    }

    public static void main(String[] strings) {
        C74 c = new C74();
        int[] num1 = new int[]{1};
        int[] num2 = new int[]{3};
//        int[] num3 = new int[]{23,30,34,50};
        int[][] nums = new int[][]{num1, num2};
        System.out.println(c.searchMatrix(nums, 3));
    }
}
