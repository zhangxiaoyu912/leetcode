package com.leetcode.solutions.bits;

public class C190_reverse_bits {
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public int swapBits(int n, int i, int j) {
        // calculate a and b so that if a^b==1 means the corresponding i and j bits different
        // otherwise no need to swap
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        // if (a^b)==1, need to shift this 1 to the opposite position on the left
        // 1<<i will be the 1 to be shifted, 1<<j is the 1 shifted to
        // n^ above will XOR the 1 on the 1<<i position
        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

    public static void main(String[] strings) {
        C190_reverse_bits c = new C190_reverse_bits();
        c.reverseBits(199999);
    }
}
