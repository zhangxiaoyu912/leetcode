package com.leetcode.solutions.substring;

import java.util.*;

public class
C128_longest_consecutive_sequence {
    /*
    Solution 1: neat code, and O(n) time complexity, using map, the `left` and `right` is tricky
     */
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    /*
    Solution 2: different thinking using set, but it is NOT O(n)
     */
    public int longestConsecutive_2(int[] nums) {
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
