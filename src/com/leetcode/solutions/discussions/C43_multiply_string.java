package com.leetcode.solutions.discussions;

public class C43_multiply_string {

    // about corner case : '0', leading '0'
    // logic->code skill
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int m = num1.length();
        int n = num2.length();
        int[] digits = new int[m + n];

        // calculate each number in 'digits'
        for (int i = m - 1; i >= 0; i --) {
            for (int j = n - 1; j >= 0; j --) {
                int pos = i + j + 1;
                int int1 = num1.charAt(i) - '0';
                int int2 = num2.charAt(j) - '0';
                int product = int1 * int2;
                int carry = 0;
                digits[pos] += product % 10;
                if (digits[pos] >= 10) {
                    carry = digits[pos] / 10;
                    digits[pos] = digits[pos] % 10;
                }
                digits[pos - 1] += product / 10 + carry;
                if (digits[pos - 1] >= 10) {
                    carry = digits[pos - 1] / 10;
                    digits[pos - 1] = digits[pos - 1] % 10;
                    if (carry > 0 && pos - 2 >= 0)
                        digits[pos - 2] += carry;
                }
            }
        }

        // remove leading '0'
        int k = 0;
        StringBuilder builder = new StringBuilder();
        while (digits[k] == 0)
            k ++;

        // convert to string
        while (k < digits.length) {
            builder.append(digits[k]);
            k ++;
        }

        return builder.toString();
    }

    public static void main(String[] strings) {
        C43_multiply_string c = new C43_multiply_string();
        System.out.println(c.multiply("123", "456"));
    }
}
