package com.leetcode.solutions.discussions;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.
 */

public class C201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {

        // this exceed time limitation
//        for (int i = m; i <= n; i ++)
//            m = m & i;
//
//        return m;

        // this only take number of bits of n, so it is fast
        // it will make all the m/n common digit to '0'
        while (n > m)
            n = n & (n - 1);

        return m & n;
    }

    public static void main(String[] strings) {
        C201_Bitwise_AND_of_Numbers_Range c = new C201_Bitwise_AND_of_Numbers_Range();
        System.out.println(c.rangeBitwiseAnd(5, 2));
    }
}
