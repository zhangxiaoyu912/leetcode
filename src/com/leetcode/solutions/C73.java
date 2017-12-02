package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class C73 {

    // solution from https://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/

    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        // it will need to use the first column and first row as projection used later one to mark the entire matrix
        // hence it will need to know if first column and first row is really 0
        // hence get the boolean first

        //set first row and column zero or not
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        // use first row and first column as the projection
        //mark zeros on first row and column
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //use mark to set elements in entire matrix
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // then come back to set first row and first column, it might come back to 1 if the boolean is false
        //set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }

        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }

    }

    // this solution use additional memory, so it is not a in place solution
//    public void setZeroes(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return;
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        Set<Integer> setM = new HashSet<>();
//        Set<Integer> setN = new HashSet<>();
//
//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j ++) {
//                if (matrix[i][j] != 0)
//                    continue;
//                else {
//                    setM.add(i);
//                    setN.add(j);
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j ++) {
//                if (setM.contains(i) || setN.contains(j))
//                    matrix[i][j] = 0;
//            }
//        }
//    }
}
