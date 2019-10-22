package com.leetcode.solutions.classic;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.
 */

public class C211 {

    // example of using Trie structure
    class WordDictionary {

        class TrieNode {
            char c;
            boolean isLeaf;
            Map<Character, TrieNode> childrean = new HashMap<>();// finish the empty list ini outside of constructor
            public TrieNode(){}
            public TrieNode(char c) {
                this.c = c;
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Map<Character, TrieNode> childrean = root.childrean;

            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);

                TrieNode t = null;
                if (childrean.containsKey(c)) {
                    t = childrean.get(c);
                } else {
                    t = new TrieNode(c);
                    childrean.put(c, t);
                }

                childrean = t.childrean;
                if (i == word.length() - 1)
                    t.isLeaf = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return dfs(word, root.childrean, 0);
        }

        private boolean dfs(String word, Map<Character, TrieNode> children, int i) {
            if (i == word.length()) {
                // means if no children, then it has to be a leaf !
                if (children.size() == 0)
                    return true;
                else
                    return false;
            } else {
                char c = word.charAt(i);
                // first check if contains, inside 'else' handle the '.' case
                if (children.containsKey(c)) {
                    // since what pass to function 'dfs' is a map, not a TrieNode
                    // so 'isLeaf' can only be proactively checked
                    if (i == word.length() - 1 && children.get(c).isLeaf) {
                        return true;
                    }

                    return dfs(word, children.get(c).childrean, i + 1);
                } else if (c == '.') {
                    boolean result = false;
                    for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
                        // for case last character is '.'
                        if (i == word.length() - 1 && child.getValue().isLeaf) {
                            return true;
                        }

                        // for '.' in the middle of the word
                        //if any path is true, set result to be true;
                        if (dfs(word, child.getValue().childrean, i + 1)) {
                            result = true;
                        }
                    }

                    return result;
                } else {
                    return false;
                }
            }
        }
    }
}
