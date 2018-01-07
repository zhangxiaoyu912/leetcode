package com.leetcode.solutions.pass;

import java.util.HashSet;

public class C3_longest_substring_without_repeat_char {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;

        HashSet<Character> set = new HashSet<Character>();

        int max=0;

        int i=0;
        int start=0;
        while(i<s.length()){
            char c = s.charAt(i);
            // only need to check contains, and don't have to maintain anohter pointer other than start (i is the right most
            if(!set.contains(c)){
                set.add(c);
            }else{
                max = Math.max(max, set.size());

                while(start<i&&s.charAt(start)!=c){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }

            i++;
        }

        max = Math.max(max, set.size());

        return max;
    }

    public static void main(String[] strings) {
        C3_longest_substring_without_repeat_char c = new C3_longest_substring_without_repeat_char();
        System.out.println(c.lengthOfLongestSubstring("abcabcbb"));// pwwkew   abcabcbb
    }
}
