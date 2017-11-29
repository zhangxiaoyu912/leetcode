package com.leetcode.solutions.checked.discussion;

/**
 * Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


 */

public class C213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int max1 = 0;
        int max2 = 0;

        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (i % 2 == 0) {
                even += nums[i];
                even = even > odd ? even : odd;
            } else {
                odd += nums[i];
                odd = odd > even ? odd : even;
            }
        }

        max1 = even > odd ? even : odd;

        even = 0;
        odd = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (i % 2 == 0) {
                even += nums[i];
                even = even > odd ? even : odd;
            } else {
                odd += nums[i];
                odd = odd > even ? odd : even;
            }
        }

        max2 = even > odd ? even : odd;

        return max1 > max2 ? max1 : max2;
    }

    public static void main(String[] strings) {
        C213 c = new C213();
        System.out.println(c.rob(new int[]{1}));
    }
}
