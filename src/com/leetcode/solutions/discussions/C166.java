package com.leetcode.solutions.discussions;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class C166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";
        String result = "";

        // is result is negative, neat ! XOR...
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }

        // long is needed for round up/down error !
        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result += String.valueOf(res);

        // if remainder is 0, return result
        // why * 10, then compare with 0 ??
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";

        // (remainder % den) * 10 -> get new remainder
        // remainder / den -> get the results, if it is not in the map
        //                     if in the map, remainder / den has been part of the result String
        while (remainder != 0) {

            // if the repeated tail is multiple digits like 345, it will be in the map already
            // the reason this work is the repeat part can be single or multiple digits
            // and for multiple digits, like (345), 3, 34, 345 are all in the map
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }
        return result;
    }

    public static void main(String[] str) {
        C166 c = new C166();
        System.out.println(c.fractionToDecimal(1, 99));
    }
}
