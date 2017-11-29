package com.leetcode.solutions.pass;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class C209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums[0] >= s)
            return 1;
        else if (nums.length == 1)
            return 0;

        int begin = 0;
        int end = 0;
        int len = nums.length;
        int base = nums[0];
        boolean meet = false;

        while (end < nums.length) {
            int temp = (end - begin + 1);
            if (base >= s) {
                meet = true;
                if (temp < len)
                    len = temp;
                else {
                    if (end == nums.length - 1 && base - nums[begin] < s)
                        break;

                    base -= nums[begin];
                    begin += 1;
                }
            } else {
                if (end + 1 < nums.length) {
                    end += 1;
                    base += nums[end];
                } else {
                    break;
                }
            }

        }

        if (meet)
            return len;
        else
            return 0;
    }

    public static void main(String[] strings) {
        C209 c = new C209();
        // 0
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(c.minSubArrayLen(100, nums));
        // 2
        nums = new int[]{2,3,1,2,4,3};
        System.out.println(c.minSubArrayLen(7, nums));

    }
}
