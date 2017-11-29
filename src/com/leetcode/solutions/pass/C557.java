package com.leetcode.solutions.pass;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 */

public class C557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;

        char[] str = s.toCharArray();
        // reverse word by word
        int b = 0;
        int e = 0;

        while (b < str.length) {
            while (e != str.length - 1 && str[e] != ' ')
                e++;

            if (str[e] == ' ') // !!! this need to be like this
                e --;

            int begin = b;
            int end = e;
            reverseStr(str, begin, end);
            e += 2;
            b = e;
        }

        return String.valueOf(str);
    }

    private void reverseStr(char[] str, int b, int e) {
        while (b < e) {// !!! this is not b != e or others
            char temp = str[b];
            str[b] = str[e];
            str[e] = temp;
            b += 1;
            e -= 1;
        }
    }
}
