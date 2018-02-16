package com.leetcode.solutions.pass;

import java.util.HashSet;
import java.util.Set;

public class C219_contains_duplicate_2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> set = new HashSet<>();
        int i = 0;
        // first stage
        while (i <= k && i < nums.length) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;

            i ++;
        }
        if (i == nums.length)
            return false;

        // second stage
        int j = 0;
        while (i < nums.length) {
            set.remove(nums[j]);
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
            j ++;
            i ++;
        }

        return false;
    }
}
