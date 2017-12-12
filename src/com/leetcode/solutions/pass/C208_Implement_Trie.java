package com.leetcode.solutions.pass;

import java.util.HashMap;
import java.util.Map;

public class C208_Implement_Trie {
    class Trie {

        class TrieNode {
            char c;
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isLeaf;

            public TrieNode(){}
            public TrieNode(char c) {
                this.c = c;
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Map<Character, TrieNode> children = root.children;
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);
                TrieNode t = null;
                if (children.containsKey(c)) {
                    t = children.get(c);
                } else {
                    t = new TrieNode(c);
                    children.put(c, t);
                }
                children = t.children;

                if (i == word.length() - 1)
                    t.isLeaf = true;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Map<Character, TrieNode> children = root.children;
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);
                TrieNode t = null;
                if (children.containsKey(c)) {
                    t = children.get(c);
                } else {
                    return false;
                }
                children = t.children;

                if (i == word.length() - 1) {
                    if (!t.isLeaf)
                        return false;
                }
            }

            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Map<Character, TrieNode> children = root.children;
            for (int i = 0; i < prefix.length(); i ++) {
                char c = prefix.charAt(i);
                TrieNode t = null;
                if (children.containsKey(c)) {
                    t = children.get(c);
                } else {
                    return false;
                }
                children = t.children;
            }
            return true;
        }

    }
}
