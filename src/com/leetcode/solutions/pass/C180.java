package com.leetcode.solutions.pass;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?

 Related problem: Rotate Array

 */

public class C180 {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0 || str.length == 1)
            return;

        // reverse the whole array
        reverseStr(str, 0, str.length - 1);

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

    public static void main(String[] strings) {
        C180 c = new C180();
        char[] str = "the sky is blue".toCharArray();
        c.reverseWords(str);
        System.out.println(str);
    }
}
