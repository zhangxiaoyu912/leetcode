package com.leetcode.solutions.dp;

public class C115_distinct_subsequence {
    // this problem is really hard to understand the DP idea
    public int numDistinct(String s, String t) {
        // Let W(i, j) stand for the number of subsequences of S(0, i) equals to T(0, j).
        // If S.charAt(i) == T.charAt(j), W(i, j) = W(i-1, j-1) + W(i-1,j); Otherwise, W(i, j) = W(i-1,j).
        int[][] table = new int[s.length() + 1][t.length() + 1];

        // init value, means if T is empty string, value will be 1 for each position in S
        for (int i = 0; i < s.length(); i++)
            table[i][0] = 1;

        // start from 1, since i-1 will start from 0
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
                } else {
                    // since S's substring equals to T, so if S.charAt(i - 1) != T.charAt(j - 1), doesn't matter, just go on
                    // the one additional letter at i-1 in S doens't effect the solution
                    table[i][j] += table[i - 1][j];
                }
            }
        }

        return table[s.length()][t.length()];
    }
}
