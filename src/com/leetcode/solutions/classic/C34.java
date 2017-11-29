package com.leetcode.solutions.classic;

public class C34 {
    public int[] searchRange(int[] nums, int target) {
        int[] invalid = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return invalid;

        int low = 0;
        int high = nums.length - 1;
        if (nums[low] > target || nums[high] < target)
            return invalid;

        if (nums[low] == target)
            return getRange(nums, low, target);
        if (nums[high] == target)
            return getRange(nums, high, target);

        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (nums[mid] < target)
                low = mid;
            else if (nums[mid] > target)
                high = mid;
            else// nums[mid] == target
                return getRange(nums, mid, target);
        }

        return invalid;
    }

    private int[] getRange(int[] nums, int mid, int target) {
        int left = mid;
        int right = mid;
        while (left >= 0 && nums[left] == target)
            left--;
        left++;
        while (right < nums.length && nums[right] == target)
            right++;
        right--;
        return new int[]{left, right};
    }

    public static void main(String[] strings) {
        C34 c = new C34();
        int[] array = c.searchRange(new int[]{-6,-5,-3,0,1, 4, 6,7,8,9}, 4);
        for (int num : array)
            System.out.println(num);
    }
}
