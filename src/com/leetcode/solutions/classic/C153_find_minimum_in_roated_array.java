package com.leetcode.solutions.classic;

public class C153_find_minimum_in_roated_array {
    public int findMin(int[] nums) {
        int start=0, end=nums.length-1;

        while (start<end) {
            if (nums[start]<nums[end])
                return nums[start];

            int mid = (start+end)/2;

            if (nums[mid]>=nums[start]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}
