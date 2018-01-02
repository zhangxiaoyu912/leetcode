package com.leetcode.solutions.classic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class C127_word_ladder {
    // this utility class can save lots of code to remember the level
    class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    // a BFS solution make sure that the min step can be made
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<WordNode> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        for (String str : wordList)
            set.add(str);

        queue.add(new WordNode(beginWord, 1));
        while(!queue.isEmpty()) {
            WordNode w = queue.poll();

            if (w.word.equals(endWord))
                return w.numSteps;

            StringBuilder b = new StringBuilder(w.word);
            for (int i = 0; i < w.word.length(); i ++) {
                char org = w.word.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == org)
                        continue;

                    b.setCharAt(i, c);
                    String str = b.toString();

                    if (set.contains(str)) {
                        queue.add(new WordNode(str, w.numSteps + 1));
                        set.remove(str);
                    }
                    b.setCharAt(i, org);
                }
            }
        }

        return 0;
    }

    public static void main(String[] strings) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        C127_word_ladder c = new C127_word_ladder();
        System.out.println(c.ladderLength("hit", "cog", wordList));
    }
}
