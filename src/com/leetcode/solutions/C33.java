package com.leetcode.solutions;

public class C33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int index = 0;
        int max = nums[index];
        int factor = 0;
        while (index < nums.length && nums[index] >= max) {
            max = nums[index];
            index += Math.pow(2, factor);
            factor ++;
        }
        index -= Math.pow(2, factor - 1);

        while (index < nums.length && nums[index] >= max) {
            max = nums[index];
            index ++;
        }
        index --;

        int high = index;
        int low = index == nums.length - 1 ? 0 : index + 1;

        while (low - (index + 1) < high - 1 + (nums.length - index - 1)) {
            int mid = ((low + high) % nums.length) / 2;
            if (nums[mid] > target)
                high = mid;
            else if (nums[mid] < target)
                low = mid;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] strings) {
        C33 c = new C33();
        System.out.println(c.search(new int[]{4,5,6,7,0,1,2}, 7));
    }
}
