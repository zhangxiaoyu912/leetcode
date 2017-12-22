package com.leetcode.solutions.classic;

public class C154_find_minmum_in_roated_sorted_array_2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high && nums[low] >= nums[high]) {
            while (high - 1 > low && nums[high - 1] == nums[high])
                high --;

            while (low + 1 < high && nums[low + 1] == nums[low])
                low ++;

            int mid = (low + high) / 2;
            if (nums[mid] < nums[high])
                high = mid;
            else
                low = mid + 1;
        }
        return nums[low];
    }
}
