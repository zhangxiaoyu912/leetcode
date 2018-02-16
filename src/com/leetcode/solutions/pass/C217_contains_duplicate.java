package com.leetcode.solutions.pass;

import java.util.HashSet;
import java.util.Set;

public class C217_contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (!s.contains(num))
                s.add(num);
            else
                return true;
        }

        return false;
    }
}
