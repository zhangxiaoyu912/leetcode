package com.leetcode.solutions.pass;

public class C66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;

        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int sum = digits[i] + plus;
            if (sum < 10) {
                digits[i] = sum;
                plus = 0;
                break;
            } else {
                digits[i] = sum % 10;
            }
        }

        if (plus == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i ++)
                res[i] = digits[i - 1];

            return res;
        }

    }
}
