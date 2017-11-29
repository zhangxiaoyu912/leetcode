package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class C166 {

    public String fractionToDecimal(int numerator, int denominator) {
        // defensive code
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String buffer = "";

        // need to handle negative, important !
        if ((numerator < 0) ^ (denominator < 0))
            buffer += "-";

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        int mod = numerator % denominator;
        int remain = numerator / denominator;
        buffer += remain;
        if (mod == 0)
            return buffer.toString();
        else
            buffer += ".";

        Map<Integer, Integer> map = new HashMap<>();
        while (mod != 0) {
            remain = mod * 10 / denominator;
            mod = (mod * 10) % denominator;

            if (map.containsKey(remain)) {
                String part1 = buffer.substring(0, map.get(remain));
                String part2 = buffer.substring(map.get(remain), buffer.length());
                buffer = part1 + "(" + part2 + ")";
                return buffer;
            } else {
                map.put(remain, buffer.length());
                buffer += remain;
            }
        }

        return buffer;
    }

    public static void main(String[] str) {
        C166 c = new C166();
        System.out.println(c.fractionToDecimal(1, 99));
    }
}
