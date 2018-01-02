package com.leetcode.solutions.discussions;

import java.util.HashSet;
import java.util.Set;

public class C128_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : nums)
            set.add(e);

        for (int e : nums) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            // the benifit of this algo is you can start from any number and get the max
            // take the example, input, the if start from 4, or 3, or 2 or 1 wil all got 4 as max value
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
