package com.leetcode.solutions.discussions;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class C120 {

    // this has to be a bottom up solution, due to the nature of the problem
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] total = new int[triangle.get(triangle.size() - 1).size()];

        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i ++)
            total[i] = triangle.get(triangle.size() - 1).get(i);

        for (int i = triangle.size() - 2; i >= 0; i --) {
            for (int j = 0; j < triangle.get(i).size(); j ++)
                total[j] = Math.min(total[j], total[j + 1]) + triangle.get(i).get(j);
        }

        return total[0];
    }

}
