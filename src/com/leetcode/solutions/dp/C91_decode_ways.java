package com.leetcode.solutions.dp;

public class C91_decode_ways {


    // DP
    // the more important is when the solution is not neat enough, think about not keep patching it but step backward
    // and polish the foundation
    // the correct solution also scan from left to right instead of from right to left because anything start with 0
    // is invalid
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')// any string start with '0' will be 0
            return 0;
        if(s.length()==1)
            return 1;

        // initial most left two digit and
        int[] dp = new int[s.length()];
        dp[0]=1;
        if(Integer.parseInt(s.substring(0,2))>26){
            if(s.charAt(1)!='0'){
                dp[1]=1;
            }else{
                dp[1]=0;
            }
        }else{
            if(s.charAt(1)!='0'){
                dp[1]=2;
            }else{
                dp[1]=1;
            }
        }

        // 304 is not a valid, since even 3 get 1, 30 doesn't so the array is [1, 0, ?]
        // since 04 is not between 10 and 26,  third element only equal to second element, which is also 0, so [1, 0, 0]
        // but if 300, then get [1, 0, 0], 260 get [1, 2, ?], since 0 doesn't form, and 60 is not between 26 and 10, hence [1, 2, 0], cannot decode actually

        // scan from left to right, the code is very neat
        for(int i=2; i<s.length(); i++){
            if(s.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            }

            int val = Integer.parseInt(s.substring(i-1, i+1));
            if(val<=26 && val >=10){// if < 10, then mean e.g 09 is not valid, then dp[i-2] doesn't valid to attach
                dp[i]+=dp[i-2];
            }
        }

        return dp[s.length()-1];



//        if (s == null || s.length() == 0)
//            return 0;
//
//        int base = Integer.parseInt(s.substring(s.length() - 1, s.length()));
//        int baseVal;
//        if (base == 0)
//            baseVal = 0;
//        else
//            baseVal = 1;
//
//        int len = s.length();
//        int[] count = new int[len + 1];
//        count[len --] = 0;
//        count[len --] = baseVal;
//        while (len >= 0) {
//            int right = Integer.parseInt(s.substring(len + 1, len + 2));
//            int left = Integer.parseInt(s.substring(len, len + 1));
//
//            if (count[len + 1] == 0 && count[len + 2] == 0 && len + 2 < s.length())
//                count[len] = 0;
//            else if (left == 0)
//                count[len] = 0;
//            else if (left * 10 + right <= 26) {
//                if (len + 2 < s.length() && count[len + 2] == 0)
//                    count[len] = count[len + 1];
//                else
//                    count[len] = Math.max(count[len + 1] + 1, count[len + 2]);
//            } else
//                count[len] = count[len + 1];
//
//            len -= 1;
//        }
//
//        return count[0];
    }

    public static void main(String[] strings) {
        C91_decode_ways c = new C91_decode_ways();
        System.out.println(c.numDecodings("307"));
    }
}