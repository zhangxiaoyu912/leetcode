package com.leetcode.solutions.pass;

public class C45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;

        int step = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] + i > max) {
                max = nums[i] + i;
                step += 1;
            }

            if (max >= nums.length - 1)
                return step;

            if (nums[i] == 0)
                return -1;

            int temp = i;
            int localMax = max;
            for (int j = i + 1; j <= max; j ++) {
                if (nums[j] + j > localMax) {
                    localMax = nums[j] + j;
                    temp = j;
                }
            }
            if (localMax > max) {
                max = localMax;
                step += 1;
                if (max >= nums.length - 1) {
                    return step;
                }
            }

            i = temp - 1;
        }

        return step;
    }

    public static void main(String[] strings) {
        C45 c = new C45();
        System.out.println(c.jump(new int[]{2,3,1,1,4}));
    }
}
