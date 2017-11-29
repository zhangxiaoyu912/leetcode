package com.leetcode.solutions.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class C198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i % 2 == 0) {
                even += nums[i];
                even = even > odd ? even : odd;
            } else {
                odd += nums[i];
                odd = odd > even ? odd : even;
            }
        }

        return even > odd ? even : odd;

        // important, think twice about giving a recursive solution !!
        // this solution exceed time limit
//        if (nums.length == 0)
//            return 0;
//        else if (nums.length == 1)
//            return nums[0];
//        else if (nums.length == 2)
//            return Math.max(nums[0], nums[1]);
//        else if (nums.length == 3)
//            return Math.max(nums[0] + nums[2], nums[1]);
//        else {
//            int comb1 = nums[0] + rob(Arrays.copyOfRange(nums, 2, nums.length));
//            int comb2 = nums[1] + rob(Arrays.copyOfRange(nums, 3, nums.length));
//            return Math.max(comb1, comb2);
//        }
    }

    public static void main(String[] strings) {
        C198 c = new C198();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(c.rob(nums));
    }
}
