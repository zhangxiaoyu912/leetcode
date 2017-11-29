package com.leetcode.solutions;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */

public class C125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        s = s.toLowerCase();

        int b = 0;
        int e = s.length() - 1;
        while (b < e) {
            char charB = s.charAt(b);
            char charE = s.charAt(e);
            if (!isAlphNum(charB)) {
                b += 1;
                continue;
            }
            if (!isAlphNum(charE)) {
                e -= 1;
                continue;
            }

            if (charB == charE) {
                b += 1;
                e -= 1;
                continue;
            } else
                return false;
        }

        return true;
    }

    private boolean isAlphNum(char sChar) {
        return (sChar - 'a' >= 0 && sChar - 'a' < 26) ||
                (sChar - '0' >= 0 && sChar - '0' < 10);
    }

    public static void main(String[] strings) {
        C125 c = new C125();
        System.out.println(c.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
