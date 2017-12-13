package com.leetcode.solutions.pass;

public class C171_excel_column_number {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // for this problem, better to make first element a initial value or special case
        int num = s.charAt(0) - 'A' + 1;
        for (int i = 1; i < s.length(); i ++)
            num = (s.charAt(i) - 'A' + 1) + (num * 26);

        return num;
    }
}
