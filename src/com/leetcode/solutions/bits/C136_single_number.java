package com.leetcode.solutions.bits;

public class C136_single_number {
    public int singleNumber(int[] nums) {
        /*
        The key to solve this problem is bit manipulation. XOR will return 1 only on two different bits. So if two numbers are           the same, XOR will return 0. Finally only one number left.
        */
        int x = 0;
        for (int a : nums) {
            x = x ^ a;
        }
        return x;
    }
}
