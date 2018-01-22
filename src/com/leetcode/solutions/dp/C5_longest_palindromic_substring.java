package com.leetcode.solutions.dp;

public class C5_longest_palindromic_substring {
    public String longestPalindrome(String s) {
        // dp solution works the best
        if(s==null || s.length()<=1)
            return s;

        int len = s.length();
        int maxLen = 1;
        boolean [][] dp = new boolean[len][len];

        String longest = s.substring(0, 1);
        for(int l=0; l<s.length(); l++){
            for(int i=0; i<len-l; i++){
                int j = i+l;
                if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;

                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        longest = s.substring(i, j+1);
                    }
                }
            }
        }

        return longest;

        // solution exceed the time limit
//         if (s.length() == 0)
//             return s;

//         int max = 0;
//         String str = s.substring(0, 1);
//         for (int i = 0; i < s.length(); i ++) {
//             int l = i;
//             int r = i;
//             String subStr = s.substring(l, r + 1);
//             while(l >= 0 && r < s.length()) {
//                 if (s.charAt(l) == s.charAt(r)) {
//                     subStr = s.substring(l, r + 1);
//                     l --;
//                     r ++;
//                 } else {
//                     break;
//                 }
//             }
//             int len = r - l + 1;
//             if (len > max) {
//                 max = len;
//                 str = subStr;
//             }
// just try again with start from l and (i + 1)
//             if (i + 1 < s.length()) {
//                 l = i;
//                 r = i + 1;
//                 subStr = s.substring(l, r + 1);
//                 while(l >= 0 && r < s.length()) {
//                     if (s.charAt(l) == s.charAt(r)) {
//                         subStr = s.substring(l, r + 1);
//                         l --;
//                         r ++;
//                     } else {
//                         break;
//                     }
//                 }
//                 len = r - l + 1;
//                 if (len > max) {
//                     max = len;
//                     str = subStr;
//                 }
//             }
//         }
//         return str;
    }
}
