package com.leetcode.solutions.pass;

import java.util.Arrays;

public class C274_h_index {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;

        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i --) {
            if (citations.length - i <= citations[i])
                h = citations.length - i;
        }

        return h;
    }
}
