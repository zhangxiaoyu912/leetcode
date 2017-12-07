package com.leetcode.solutions.pass;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 */

public class C161 {

    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1)
            return false;

        int is = 0;
        int it = 0;
        int diff = 0;
        while(is < s.length() && it < t.length()) {
            if (diff > 1)
                return false;

            if (s.charAt(is) == t.charAt(it)) {
                is += 1;
                it += 1;
                continue;
            } else {
                diff += 1;
                if (it + 1 < t.length() && t.charAt(it + 1) == s.charAt(is))
                    it += 1;
                else if (is + 1 < s.length() && s.charAt(is + 1) == t.charAt(it))
                    is += 1;
                else {
                    is += 1;
                    it += 1;
                }
                // this entire else block can be replaced by
//                if(s.length() > t.length()){
//                    is ++;
//                }else if(s.length() < t.length()){
//                    it ++;
//                }else{
//                    is ++;
//                    it ++;
//                }
            }
        }

        diff += Math.abs((s.length() - is) - (t.length() - it));
        // can be replaced by
//        if(is < s.length() || it < t.length()){
//            diff ++;
//        }

        if (diff == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] strs) {
        C161 c = new C161();
        System.out.println(c.isOneEditDistance("acabac", "ababa"));
    }

}
