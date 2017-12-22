package com.leetcode.solutions.pass;

import java.util.HashSet;
import java.util.Set;

public class C159_longest_substring_with_at_most_two_distinct_characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int max = 1;
        for (int i = 0; i < s.length(); i ++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j ++) {
                set.add(s.charAt(j));
                if (set.size() <= 2)
                    max = Math.max(max, j - i + 1);
                else
                    break;
            }
        }

        return max;
    }
}
