package com.leetcode.solutions.discussions;

public class C43_multiply_string {

    /*
    fixme: Solution 1: this is a much cleaner solution, notice the carry over in pos[p2] will be take care next time, each time only take care one
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];// fixme: max length, and initial value is 0, hence not filling digits are leading 0

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /*
    Solution 2: this is my original solution, it is lengthy and process potentially 3 digits once a time
     */
    // about corner case : '0', leading '0'
    // logic->code skill
    public String multiply_2(String num1, String num2) {
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
