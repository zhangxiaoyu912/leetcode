package com.leetcode.solutions.classic;

public class C135_candy {
    public int candy(int[] ratings) {
        // solution, only scan twice
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        candies[0] = 1;

        //from let to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                // if not ascending, assign 1
                candies[i] = 1;
            }
        }

        // assign total to result, hence the 2nd scan from right to left will get the total by the way
        int result = candies[ratings.length - 1];

        //from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if (ratings[i] > ratings[i + 1]) {
                cur = candies[i + 1] + 1;
            }

            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }

        return result;

        // my solution, O(n^2) which exceed the time limit for last test case
//         if (ratings == null || ratings.length == 0)
//             return 0;

//         int[] nums = new int[ratings.length];
//         for (int i = 0; i < ratings.length; i ++) {
//             nums[i] = nums[i] > 1 ? nums[i] : 1;
//             if (i - 1 >= 0 && ratings[i] < ratings[i - 1] && nums[i] >= nums[i - 1]) {
//                 int p = i;
//                 while (p - 1 >= 0 && ratings[p] < ratings[p - 1] && nums[p] >= nums[p - 1]) {
//                     nums[p - 1] = nums[p] + 1;
//                     p --;
//                 }
//             }

//             if (i + 1 < ratings.length && ratings[i] < ratings[i + 1] && nums[i] >= nums[i + 1]) {
//                 int q = i;
//                 while (q + 1 < ratings.length && ratings[q] < ratings[q + 1] && nums[q] >= nums[q + 1]) {
//                     nums[q + 1] = nums[q] + 1;
//                     q ++;
//                 }
//                 i = q - 1;
//             }
//         }

//         int total = 0;
//         for (int num : nums)
//             total += num;

//         return total;
    }
}
