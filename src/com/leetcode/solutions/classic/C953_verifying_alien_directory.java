package com.leetcode.solutions.classic;

public class C953_verifying_alien_directory {

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; ++i) { map[order.charAt(i) - 'a'] = i; } // construct mapping to the given order.
        outer:
        for (int i = 1; i < words.length; ++i) { // Verify the adjacent words order.
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); ++j) { // compare the 2 words char by char.
                int pre = words[i - 1].charAt(j) - 'a', cur = words[i].charAt(j) - 'a'; // corresponding indexes in mapping array `map`.
                if (map[pre] > map[cur]) { return false; } // if their relation is NOT compliant with `order`, false.
                else if (map[pre] < map[cur]) { continue outer; } // if current char > previous char, no need to check following chars.
            } // NOTE: only when 1 word is the prefix of the other, can the code excute the following if clause.
            if (words[i - 1].length() > words[i].length()) { return false; } //  current word must NOT be the prefix of and shorter than previous word.
        }
        return true;
    }

    /*
    Solution 2
     */
    public boolean isAlienSorted_2(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; ++i) { map[order.charAt(i) - 'a'] = i; } // construct mapping to the give order.
        for (int i = 1; i < words.length; ++i) { // Verify the ajacent words order.
            if (compare(words[i - 1], words[i], map) > 0) { return false; }
        }
        return true;
    }
    private int compare(String s, String t, int[] map) { // compare the 2 words char by char.
        int m = s.length(), n = t.length();
        for (int i = 0; i < m && i < n; ++i) {
            int cmp = map[s.charAt(i) - 'a'] - map[t.charAt(i) - 'a']; // compare according to the given order.
            if (cmp != 0) { return cmp; } // if not equal, return the comparison result.
        }
        return m - n; // when one word is the prefix of the other, compare their sizes.
    }
}
