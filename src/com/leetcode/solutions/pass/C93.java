package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;

public class C93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() > 12 || s.length() < 4)
            return result;

        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int i) {
        if (list.size() == 4) {
            if (i < s.length())
                return;

            StringBuilder builder = new StringBuilder();
            for (String str : list)
                builder.append(str).append(".");

            builder.deleteCharAt(builder.length() - 1);
            result.add(builder.toString());

            return;

        } else {
            for (int j = i + 1; j <= s.length(); j ++) {
                String str = s.substring(i, j);
                if (valid(str)) {// if not valid, this j is invalid, continue
                    list.add(str);
                    helper(result, list, s, j);
                    list.remove(list.size() - 1);
                }
                // but if str > 255, increase j will waste of resource, should bail out earlier
                long num = Long.parseLong(str);
                if (num > 255)
                    break;
            }
        }
    }

    private boolean valid(String str) {
        // this part is the most interesting part of this question
        if(str.charAt(0) == '0')
            return str.equals("0"); // to eliminate cases like "00", "10"
        long num = Long.parseLong(str);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] strings) {
        C93 c = new C93();
        List<String> list = c.restoreIpAddresses("25525511135");
        for (String str : list)
            System.out.println(str);
    }
}
