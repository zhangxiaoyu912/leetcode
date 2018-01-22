package com.leetcode.solutions.pass;

import java.util.ArrayList;

public class C17_letter_combinations_of_a_phone_number {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return result;

        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder current = new StringBuilder();

        int index = 0;
        buildResult(digits, index, current, keyboard, result);
        return result;
    }

    private void buildResult(String digits, int index, StringBuilder current, String[] keyboard, ArrayList<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int num = digits.charAt(index) - '0';//get integer number
        for (int i = 0; i < keyboard[num].length(); i++) {
            current.append(keyboard[num].charAt(i));
            buildResult(digits, index + 1, current, keyboard, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
