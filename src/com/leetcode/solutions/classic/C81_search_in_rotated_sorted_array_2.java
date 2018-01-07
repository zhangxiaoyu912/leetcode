package com.leetcode.solutions.classic;

public class C81_search_in_rotated_sorted_array_2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            while (high - 1 >= low && nums[high - 1] == nums[high])
                high --;
            while (low + 1 <= high && nums[low + 1] == nums[low])
                low ++;

            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;

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

            // notice the while loop from solution is a little bit different
            /*
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return true;

            if(nums[left]<nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(nums[left]>nums[mid]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                left++;
            }
            */
        }

        return false;
    }
}
