package com.leetcode.solutions.pass;

public class C544_reverse_string_2 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0)
            return s;

        char[] chars = s.toCharArray();
        int len = s.length();
        int l = 0;
        int r = Math.min(len - 1, k - 1);
        while (l < len) {
            reverse(chars, l, r);
            l = r + k + 1;
            r = Math.min(r + 2*k, len - 1);
        }

        return String.copyValueOf(chars);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l ++;
            r --;
        }
    }
}
