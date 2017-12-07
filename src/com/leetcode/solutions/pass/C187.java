package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */

public class C187 {

    // the length is fixed 10 makes it easy
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> list = new HashSet<>();
        Set<String> set = new HashSet<>();
        if (s.length() < 10)
            return new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        int start = 0;
        int end = 0;
        while (end < 10) {
            builder.append(s.charAt(end));
            end += 1;
        }
        end -= 1;

        set.add(builder.toString());
        while (end + 1 < s.length()) {
            start += 1;
            end += 1;
            builder.deleteCharAt(0);
            builder.append(s.charAt(end));
            String str = builder.toString();
            if (set.contains(str))
                list.add(str);
            else
                set.add(str);
        }

        List<String> res = new ArrayList<>();
        for (String str : list)
            res.add(str);

        return res;
    }

    public static void main(String[] strs) {
        C187 c = new C187();
        List<String> list = c.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String str : list)
            System.out.println(str);
    }
}
