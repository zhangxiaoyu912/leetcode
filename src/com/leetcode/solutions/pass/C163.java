package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */

public class C163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            if (lower == upper)
                list.add(String.valueOf(lower));
            else
                list.add(lower + "->" + upper);

            return list;
        }

        // no gap
        if (lower == upper)
            return list;

        int i = 0;
        if (lower < nums[i]) {
            if (lower == nums[i] - 1)
                list.add(String.valueOf(lower));
            else
                list.add(lower + "->" + (nums[i] - 1));
        }

        for (i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 1] - 1)
                continue;
            else if (nums[i] == nums[i + 1] - 2)
                list.add(String.valueOf(nums[i + 1] - 1));
            else
                list.add(String.valueOf(nums[i] + 1) + "->" + String.valueOf(nums[i + 1] - 1));
        }

        if (nums[i] < upper) {
            if (nums[i] + 1 == upper)
                list.add(String.valueOf(upper));
            else
                list.add((nums[i] + 1) + "->" + upper);
        }

        return list;
    }

    public static void main(String[] str) {
        C163 c = new C163();
        int[] array = new int[]{-2147483648,-2147483648,0,2147483647,2147483647};//{0, 1, 3, 50, 75};
        List<String> list = c.findMissingRanges(array, -2147483648, 2147483647);
        for (String str1 : list)
            System.out.println(str1);
    }
}
