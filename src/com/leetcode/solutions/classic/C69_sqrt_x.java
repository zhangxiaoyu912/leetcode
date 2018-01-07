package com.leetcode.solutions.classic;

public class C69_sqrt_x {
    public int mySqrt(int x) {
        long high = x/2 + 1;
        long low = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long sqt = mid * mid;
            if (sqt == (long) x)
                return (int)mid;

            if (sqt < (long) x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)high;
    }
}
