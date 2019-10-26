package com.leetcode.solutions.discussions;

public class C172_factorial_trailing_zeros {
    public int trailingZeroes(int n) {
        if (n < 0)
            return -1;

        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {// only 2*5 generate trailing zero, and go through 5 in each step, will include one 2 and one 5 !
            count += n / i;
        }

        return count;
    }
}
