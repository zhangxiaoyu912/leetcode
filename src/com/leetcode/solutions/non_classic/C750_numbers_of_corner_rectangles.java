package com.leetcode.solutions.non_classic;

public class C750_numbers_of_corner_rectangles {

    // https://www.cnblogs.com/grandyang/p/8433813.html

    // basic ones, kind of brute force
//    int countCornerRectangles(vector<vector<int>>& grid) {
//        int m = grid.size(), n = grid[0].size(), res = 0;
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] == 0) continue;
//                for (int h = 1; h < m - i; ++h) {
//                    if (grid[i + h][j] == 0) continue;
//                    for (int w = 1; w < n - j; ++w) {
//                        if (grid[i][j + w] == 1 && grid[i + h][j + w] == 1) ++res;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    // improved one
//    int countCornerRectangles(vector<vector<int>>& grid) {
//        int m = grid.size(), n = grid[0].size(), res = 0;
//        for (int i = 0; i < m; ++i) {
//            for (int j = i + 1; j < m; ++j) {
//                int cnt = 0;
//                for (int k = 0; k < n; ++k) {
//                    if (grid[i][k] == 1 && grid[j][k] == 1) ++cnt;
//                }
//                res += cnt * (cnt - 1) / 2;
//            }
//        }
//        return res;
//    }

    // even better
//    int countCornerRectangles(vector<vector<int>>& grid) {
//        int m = grid.size(), n = grid[0].size(), res = 0;
//        for (int i = 0; i < m - 1; i++) {
//            vector<int> ones;
//            for (int k = 0; k < n; k++) if (grid[i][k]) ones.push_back(k);
//            for (int j = i + 1; j < m; j++) {
//                int cnt = 0;
//                for (int l = 0; l < ones.size(); l++) {
//                    if (grid[j][ones[l]]) cnt++;
//                }
//                res += cnt * (cnt - 1) / 2;
//            }
//        }
//        return res;
//    }
}
