package com.leetcode.solutions.shouldPass;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 UPDATE (2017/1/20):
 The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class C127 {

    /**
     * the hard part of this problem is thinking of 'two way BFS' and always switch to the 'easy' (less) side
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }

            Set<String> temp = new HashSet<>();
            for (String curr : beginSet) {
                char[] currChar = curr.toCharArray();
                for (int i = 0; i < currChar.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (currChar[i] == c)
                            continue;

                        char oldChar = currChar[i];
                        currChar[i] = c;
                        String currNew = String.valueOf(currChar);

                        if (endSet.contains(currNew))
                            return level + 1;

                        if (!visited.contains(currNew) && wordList.contains(currNew)) {
                            visited.add(currNew);
                            temp.add(currNew);
                        }
                        currChar[i] = oldChar;
                    }
                }
            }

            beginSet = temp;
            level ++;
        }

        return 0;
    }
}
