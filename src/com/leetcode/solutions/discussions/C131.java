package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.List;

public class C131 {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        if (s == null || s.length() == 0)
            return lists;

        List<String> par = new ArrayList<>();
        addPartition(s, 0, par, lists);
        return lists;
    }

    private void addPartition(String s, int start, List<String> par, List<List<String>> lists) {
        if (start == s.length()) {
            List<String> temp = new ArrayList<>(par);
            lists.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i ++) {
            String subStr = s.substring(start, i);
            if (isPalindrome(subStr)) {
                par.add(subStr);
                addPartition(s, i, par, lists);
                par.remove(par.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int b = 0;
        int e = s.length() - 1;
        while (b < e) {
            if (s.charAt(b) == s.charAt(e)) {
                b += 1;
                e -= 1;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] strings) {
        C131 c = new C131();
        List<List<String>> lists = c.partition("cdd");
        for (List<String> list : lists) {
            System.out.println("==============");
            for (String str : list) {
                System.out.println(str + " ");
            }
        }
    }
}
