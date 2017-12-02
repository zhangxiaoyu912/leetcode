package com.leetcode.solutions.pass;

public class C67 {
    public String addBinary(String a, String b) {
        if (a == null || a.equals(""))
            return b;
        if (b == null || b.equals(""))
            return a;

        int ia = a.length() - 1;
        int ib = b.length() - 1;

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        // think about why there will be case of 0, 1, 2, 3
        while (ia >= 0 || ib >= 0) {
            int numA = ia >= 0 ? Integer.parseInt("" + a.charAt(ia)) : 0;
            int numB = ib >= 0 ? Integer.parseInt("" + b.charAt(ib)) : 0;

            int sum = numA + numB + carry;
            if (sum == 0) {
                builder.insert(0, sum);
                carry = 0;
            } else if (sum == 1) {
                builder.insert(0, sum);
                carry = 0;
            } else if (sum == 2) {
                builder.insert(0, 0);
                carry = 1;
            } else if (sum == 3) {
                builder.insert(0, 1);
                carry = 1;
            }

            ia -= 1;
            ib -= 1;
        }

        if (carry == 1)
            builder.insert(0, carry);

        return builder.toString();
    }

    public static void main(String[] strings) {
        C67 c = new C67();
        System.out.println(c.addBinary("0", "1"));
    }
}
