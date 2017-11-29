package com.leetcode.solutions.pass;

public class C70 {
    public int climbStairs(int n) {
        // DP solution
        int[] res = new int[n];

        for (int i = 1; i <= n; i ++) {
            if (i == 1)
                res[i - 1] = 1;
            else if (i == 2)
                res[i - 1] = 2;
            else
                res[i - 1] = res[i - 2] + res[i - 3];
        }

        return res[n - 1];

        // recursively, time exceed
//        if (n <= 0)
//            return 0;
//        else if (n == 1)
//            return 1;
//        else if (n == 2)
//            return 2;
//
//        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] strings) {
        C70 c = new C70();
        System.out.println(c.climbStairs(44));
    }
}
