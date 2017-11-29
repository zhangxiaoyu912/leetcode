package com.leetcode.solutions.pass;

public class C55 {
    public boolean canJump(int[] nums) {
        if (nums == null)
            return false;

        if (nums.length <= 1)
            return true;

        for (int i = 0; i < nums.length; i ++) {
            int max = i + nums[i];
            if (max >= nums.length - 1)
                return true;

            if (nums[i] == 0)
                return false;

            int temp = i;
            for (int j = i; j <= max; j ++) {
                if (j + nums[j] >= max) {
                    max = j + nums[j];
                    temp = j;

                    if (max >= nums.length - 1)
                        return true;
                }
            }

            i = temp - 1;
        }

        return false;
    }

    public static void main(String[] strings) {
        C55 c = new C55();
        int[] nums = new int[]{2, 5, 0, 0};
        System.out.println(c.canJump(nums));
    }

    // A = [2,3,1,1,4], return true.

    // A = [3,2,1,0,4], return false.
}
