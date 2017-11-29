package com.leetcode.solutions.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 UPDATE (2017/1/4):
 The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class C139 {

    // brute force way, works though
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//        for (String word : wordDict) {
//            if (s.equals(word))
//                return true;
//
//            if (s.startsWith(word)) {
//                boolean flag = wordBreak(s.substring(word.length(), s.length()), wordDict);
//                if (flag == false)
//                    continue;
//                if (flag == true)
//                    return true;
//            }
//        }
//        return false;
//
//    }

    // DP
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;

        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;

        for (int i = 0; i < s.length(); i ++) {
            if (!t[i])
                continue;

            for (String word : wordDict) {
                int len = word.length();
                int end = i + len;

                // can ignore this 'word' since it exceed the s length
                if(end > s.length())
                    continue;

                // can continue since it is already marked
                if(t[end]) continue;

                if (s.substring(i, end).equals(word))
                    t[end] = true;
            }
        }

        return t[s.length()];
    }

    // another more simple and time friendly solution, O(n)
    public boolean wordBreak(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }

    public static void main(String[] args) {
        C139 problem = new C139();
        ArrayList<String> list = new ArrayList<String>() {{
            add("car");
            add("ca");
            add("rs");
        }};
        boolean flag = problem.wordBreak("cars", list);
        System.out.println(flag);
    }
}
