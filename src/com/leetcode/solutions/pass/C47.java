package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        Set<List<Integer>> set = new HashSet<>();
        helper(nums, 0, set);
        for (List<Integer> l : set)
            result.add(l);
        return result;
    }

    private void helper(int[] nums, int i, Set<List<Integer>> set) {
        if (i >= nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);

            set.add(temp);
            return;
        } else {
            for (int j = i; j < nums.length; j ++) {
                swap(nums, i, j);
                helper(nums, i + 1, set);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
