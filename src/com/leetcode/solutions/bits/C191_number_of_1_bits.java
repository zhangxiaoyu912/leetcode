package com.leetcode.solutions.bits;

public class C191_number_of_1_bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 1; i < 33; i ++) {
            if (getBit(n, i))
                count ++;
        }
        return count;
    }

    private boolean getBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
