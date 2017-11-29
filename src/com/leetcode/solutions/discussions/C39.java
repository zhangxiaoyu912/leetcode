package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */

public class C39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

        for (int i = j; i< candidates.length; i ++) {
            if (candidates[i] > target)
                return;

            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, current, list);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] strings) {
        C39 c = new C39();
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = c.combinationSum(candidates, 7);
        for (List<Integer> list : lists) {
            System.out.println("--------------------");
            for (int num : list)
                System.out.println(num);
        }
    }
}
