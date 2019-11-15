package com.leetcode.solutions.pass;

public class C14_longest_common_prefix {

    /*
    Solution 1: much neater code, same complexity though
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    /*
    Solution 2: easy to understand, lengthy
     */
    public String longestCommonPrefix_2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        StringBuilder builder = new StringBuilder();
        int p = 0;
        while (p < strs[0].length()) {
            char c = strs[0].charAt(p);
            boolean mismatch = false;
            for (int i = 1; i < strs.length; i ++) {
                if (p >= strs[i].length() || strs[i].charAt(p) != c) {
                    mismatch = true;
                    break;
                }
            }

            if (mismatch)
                break;

            builder.append(c);

            p++;
        }

        return builder.toString();
    }

    public static void main(String[] strings) {
        C14_longest_common_prefix c = new C14_longest_common_prefix();
        String[] strings1 = new String[]{"a", "b"};
        c.longestCommonPrefix(strings1);
    }
}
