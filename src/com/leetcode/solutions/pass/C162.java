package com.leetcode.solutions.pass;

/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */

public class C162 {

    public int findPeakElement(int[] nums) {
        int len = nums.length;

        if (len == 0)
            return -1;

        if (len == 1)
            return 0;

        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                if ((i + 1) < len && nums[i] > nums[i + 1])
                    return i;
                else
                    continue;
            }

            if (i == len - 1) {
                if (i - 1 >= 0 && nums[i] > nums[i - 1])
                    return i;
                else
                    continue;
            }

            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }

        return -1;
    }

    public static void main(String[] str) {
        C162 c = new C162();
        int[] array = new int[]{1, 2, 3, 1};
        System.out.println(c.findPeakElement(array));
    }
}
