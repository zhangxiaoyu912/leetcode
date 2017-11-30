package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */

public class C40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return list;

        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, current, list);

        return list;
    }

    private void combinationSum(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> list) {
        // make a deep copy !!!
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(current);
            list.add(temp);
            return;
        }

        int prev = -1;
        for (int i = j; i< candidates.length; i ++) {
            if (candidates[i] > target)
                return;

            // the if condition also prevent duplicate
            if (prev != candidates[i]) {
                current.add(candidates[i]);
                // pass 'i + 1' instead of 'i' will prevent duplicate
                combinationSum(candidates, target - candidates[i], i + 1, current, list);
                current.remove(current.size() - 1);
                prev = candidates[i];
            }
        }
    }

    public static void main(String[] strings) {
        C40 c = new C40();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = c.combinationSum2(candidates, 8);
        for (List<Integer> list : lists) {
            System.out.println("--------------------");
            for (int num : list)
                System.out.println(num);
        }
    }
}
