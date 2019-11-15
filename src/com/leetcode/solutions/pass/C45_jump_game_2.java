package com.leetcode.solutions.pass;

public class C45_jump_game_2 {

    /*
    Solution 1: neat code
    The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd],
    curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
    Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest
     */
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    /*
    Solution 2: original solution from me
     */
    public int jump_2(int[] nums) {
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
        C45_jump_game_2 c = new C45_jump_game_2();
        System.out.println(c.jump(new int[]{2,3,1,1,4}));
    }
}
