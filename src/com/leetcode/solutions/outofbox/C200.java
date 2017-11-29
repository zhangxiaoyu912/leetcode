package com.leetcode.solutions.outofbox;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */

public class C200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0)
            return count;

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '0')
                    continue;
                else
                    count += 1;

                mark(grid, i, j);
            }
        }

        return count;
    }

    private void mark(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i + 1 < grid.length && grid[i + 1][j] == '1')
            mark(grid, i + 1, j);

        if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
            mark(grid, i , j + 1);

        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            mark(grid, i - 1, j);

        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            mark(grid, i, j - 1);
    }

    public static void main(String[] strs) {
        C200 c = new C200();
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        System.out.println(c.numIslands(grid));
    }
}
