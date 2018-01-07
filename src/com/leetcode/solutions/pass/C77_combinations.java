package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;

public class C77_combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if (k == 0)
            return lists;

        List<Integer> l = new ArrayList<>();
        combine(n, 1, k, lists, l);
        return lists;
    }

    private void combine(int n, int start, int k, List<List<Integer>> lists, List<Integer> l) {
        if (l.size() == k) {
            List<Integer> temp = new ArrayList<>(l);
            lists.add(temp);
            return;
        } else {
            for (int i = start; i <= n; i ++) {
                l.add(i);
                combine(n, i + 1, k, lists, l);
                l.remove(l.size() - 1);
            }
        }
    }
}
