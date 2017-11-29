package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;

public class C54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;

        int xL = 0;
        int xR = matrix.length - 1;
        int yL = 0;
        int yR = matrix[0].length - 1;

        spiralOrder(list, matrix, xL, xR, yL, yR);
        return list;
    }

    private void spiralOrder(List<Integer> list, int[][] matrix, int xL, int xR, int yL, int yR) {
        if (xL > xR && yL > yR)
            return;

        if (xL == xR && yL == yR) {
            list.add(matrix[xL][yL]);
        } else if (xL < xR && yL < yR) {
            for (int j = yL; j < yR; j++)
                list.add(matrix[xL][j]);

            for (int i = xL; i < xR; i++)
                list.add(matrix[i][yR]);

            for (int j = yR; j > yL; j--)
                list.add(matrix[xR][j]);

            for (int i = xR; i > xL; i--)
                list.add(matrix[i][yL]);
        } else if (xL < xR && yL == yR) {
            for (int i = xL; i <= xR; i ++)
                list.add(matrix[i][yL]);
        } else if (xL == xR && yL < yR) {
            for (int j = yL; j <= yR; j ++)
                list.add(matrix[xL][j]);
        }

        xL ++;
        xR --;
        yL ++;
        yR --;

        spiralOrder(list, matrix, xL, xR, yL, yR);
    }

    public static void main(String[] strings) {
        C54 c = new C54();
        int[] num1 = new int[]{};
//        int[] num2 = new int[]{4};
//        int[] num3 = new int[]{7};
        int[][] nums = new int[][]{};
        List<Integer> list = c.spiralOrder(nums);
        System.out.println(list);
    }
}
