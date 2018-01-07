package com.leetcode.solutions.classic;

public class C33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
