package com.leetcode.solutions.classic;

public class C680_validate_panlindrome_2 {

    // the solution code is very neat
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }

//     public boolean validPalindrome(String s) {
//         int l = 0;
//         int r = s.length() - 1;
//         boolean delete = false;
//         while (l < r) {
//             if (s.charAt(l) == s.charAt(r)) {
//                 l ++;
//                 r --;
//             } else {
//                 if (delete) {
//                     return false;
//                 } else {
//                     if (s.charAt(l + 1) == s.charAt(r)) {
//                         l += 2;
//                         r --;
//                         delete = true;
//                     } else if (s.charAt(l) == s.charAt(r - 1)) {
//                         l ++;
//                         r -= 2;
//                         delete = true;
//                     } else {
//                         return false;
//                     }
//                 }
//             }
//         }

//         return true;
//     }
}
