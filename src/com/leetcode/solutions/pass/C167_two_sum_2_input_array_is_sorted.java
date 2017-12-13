package com.leetcode.solutions.pass;

public class C167_two_sum_2_input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int b = 0;
        int e = numbers.length - 1;
        while (b < e) {
            int sum = numbers[b] + numbers[e];
            if (sum == target)
                return new int[]{b + 1, e + 1};
            else if (sum > target)
                e --;
            else
                b ++;
        }

        return new int[]{-1, -1};
    }
}
