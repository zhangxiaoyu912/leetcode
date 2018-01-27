package com.leetcode.solutions.classic;

public class C27_remove_element {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int j = 0;
        int i = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i ++;
            }
            j ++;
        }

        return i;
    }
}
