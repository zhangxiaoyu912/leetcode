package com.leetcode.solutions.pass;

public class C75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int red = 0;
        int white = 0;
        int blue = 0;
        for (int num : nums) {
            if (num == 0)
                red += 1;
            else if (num == 1)
                white += 1;
            else if (num == 2)
                blue += 1;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (red > 0) {
                nums[i] = 0;
                red -= 1;
            } else if (white > 0) {
                nums[i] = 1;
                white -= 1;
            } else if (blue > 0) {
                nums[i] = 2;
                blue -= 1;
            }
        }
    }
}
