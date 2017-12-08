package com.leetcode.solutions.classic;

public class C214 {

    // fully utilize String util
    public String shortestPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(j>=0){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j--;
        }

        if(i==s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix+mid+suffix;
    }

    // my solution, time exceed for the last test case
//     public String shortestPalindrome(String s) {
//         if (s == null || s.length() < 2)
//             return s;

//         int mid = (s.length() - 1) / 2;
//         String res = s;
//         int right = mid;
//         int left = mid;
//         while(mid > 0) {
//             right = mid + 1;
//             left = mid - 1;

//             while (right < s.length() && s.charAt(right) == s.charAt(mid))
//                 right ++;

//             while (left >= 0 && s.charAt(left) == s.charAt(mid))
//                 left --;

//             while (left >= 0 && right < s.length()) {
//                 if (s.charAt(left) == s.charAt(right)) {
//                     right ++;
//                     left --;
//                     continue;
//                 } else {
//                     break;
//                 }
//             }

//             if (left == -1)
//                 break;
//             else
//                 mid --;
//         }

//         if (mid == 0)
//             right = 1;

//         while(right < s.length()) {
//             res = s.charAt(right) + res;
//             right ++;
//         }

//         return res;
//     }

    public static void main(String[] strings) {
        C214 c = new C214();
        System.out.println(c.shortestPalindrome("abacd"));
    }
}
