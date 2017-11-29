package com.leetcode.solutions.classic;

import java.util.ArrayList;
import java.util.List;

public class C140 {

    // this is the DP solution
    // the second version of solution is available at https://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        List<String> t[] = new ArrayList[s.length() + 1];
        t[0] = new ArrayList<>();

        for (int i = 0; i < s.length(); i ++) {
            if (t[i] == null)
                continue;

            for (String word : wordDict) {
                int len = word.length();
                int end = i + len;

                if (end > s.length())
                    continue;

                if (s.substring(i, end).equals(word)) {
                    if (t[end] == null)
                        t[end] = new ArrayList<>();

                    t[end].add(word);
                }
            }
        }

        List<String> result = new ArrayList<>();
        if (t[s.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<>();
        dfs(t, s.length(), result, temp);

        return result;
    }

    private void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--){
                path += " " + tmp.get(i) ;
            }

            result.add(path);
            return;
        }

        for(String str : dp[end]){
            tmp.add(str);
            dfs(dp, end-str.length(), result, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] strings) {
        C140 c = new C140();
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        List<String> res = c.wordBreak("leetcode", wordDict);
    }
}
