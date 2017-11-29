package com.leetcode.solutions.discussions;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */

public class C189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1 || k == 0)
            return;

        k = k < nums.length ? k : k % nums.length;
        int a = nums.length - k;

        // solution 1 : need extra memory and traverse twice
//
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i ++) {
//            int pos = (i + k) % nums.length;
//            res[pos] = nums[i];
//        }
//
//        for (int i = 0; i < res.length; i ++)
//            nums[i] = res[i];

        // solution 2 : tricky one, reverse based
        reverseIntArray(nums, 0, a - 1);
        reverseIntArray(nums, a, nums.length - 1);
        reverseIntArray(nums, 0, nums.length - 1);
    }

    private void reverseIntArray(int[] nums, int b, int e) {
        while (b < e) {// !!! this is not b != e or others
            int temp = nums[b];
            nums[b] = nums[e];
            nums[e] = temp;
            b += 1;
            e -= 1;
        }
    }

    public static void main(String[] strings) {
        C189 c = new C189();
        int[] nums = new int[]{1, 2};
        c.rotate(nums, 1);
        for (int num : nums)
            System.out.println(num);
    }
}
