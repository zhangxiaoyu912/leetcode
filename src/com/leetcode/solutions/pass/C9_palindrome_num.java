package com.leetcode.solutions.pass;

public class C9_palindrome_num {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;

        int l = 0;
        int p = x;
        while (p > 0) {
            p = p / 10;
            l ++;
        }

        int r = 1;
        int xR = x;
        int xL = x;
        while (l > r) {
            int right = xR % 10;
            xR = xR / 10;
            int left = xL / (int)(Math.pow(10, l - 1));
            xL = xL % (int)(Math.pow(10, l - 1));
            if (right != left)
                return false;

            l --;
            r ++;
        }

        return true;
    }
}
