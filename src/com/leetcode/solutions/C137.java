package com.leetcode.solutions;

/**
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class C137 {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            // if appear 3 times : (ones ^ nums[i]) & ~twos make itself since ~two is all 1
            //          then ~once is the reverse of itself, then (twos ^ nums[i]) & ~ones, makes it all 0, then twos all 0
            //          then ~twos is all 1, since (ones ^ nums[i]) makes 0, hence 0 & 1 will be 0
            // but if it only appear once, then once & 1 (1 = ~0) will be itself
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public static void main(String[] strings) {
        C137 c = new C137();
        int[] nums = new int[]{1,1,1,2,2,2,3};
        c.singleNumber(nums);
    }
}
