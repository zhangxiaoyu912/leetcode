package com.leetcode.solutions.classic;

import java.util.*;

public class C127_word_ladder {

    /*
    Solution 1: same as solution 2, BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        for (int len = 1; !q.isEmpty(); len++) {
            for (int i = q.size(); i > 0; i--) {// fixme: this way each time only process what has been offered to quene in last round
                                                // fixme: use len to record number of step
                String w = q.poll();
                if (w.equals(endWord)) return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();// no StringBuilder as well
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (dict.contains(nb) && vis.add(nb)) q.offer(nb);
                    }
                }
            }
        }
        return 0;
    }

    /*
    Solution 2, has a class contains the length
     */
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
    public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {
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
