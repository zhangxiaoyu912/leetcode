package com.leetcode.solutions.classic;

import java.util.ArrayList;
import java.util.List;

public class C46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i >= nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);

            result.add(temp);
            return;
        } else {
            for (int j = i; j < nums.length; j ++) {
                swap(nums, i, j);
                helper(nums, i + 1, result);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] strings) {
        C46 c = new C46();
        System.out.println(c.permute(new int[]{1, 2, 3}));
    }
}
