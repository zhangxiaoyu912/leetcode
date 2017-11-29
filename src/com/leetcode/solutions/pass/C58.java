package com.leetcode.solutions.pass;

public class C58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        String[] array = s.split(" ");
        return array.length == 0 ? 0 : array[array.length - 1].length();
    }
}
