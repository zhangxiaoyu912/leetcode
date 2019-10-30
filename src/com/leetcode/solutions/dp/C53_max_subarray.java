package com.leetcode.solutions.dp;

public class C53_max_subarray {

    //The changing condition for dynamic programming is "We should ignore the sum of the previous n-1 elements if nth element is greater than the sum."

    // here is a easier to understand version
//    public int maxSubArray(int[] A) {
//        int max = A[0];
//        int[] sum = new int[A.length];
//        sum[0] = A[0];
//
//        for (int i = 1; i < A.length; i++) {
//            sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
//            max = Math.max(max, sum[i]);
//        }
//
//        return max;
//    }

    // this is the neat version
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int sumMax = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            sum = Math.max(nums[i], sum + nums[i]);
            sumMax = Math.max(sum, sumMax);
        }

        return sumMax;
    }

    public static void main(String[] strings) {
        C53_max_subarray c = new C53_max_subarray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(c.maxSubArray(nums));
    }
}
