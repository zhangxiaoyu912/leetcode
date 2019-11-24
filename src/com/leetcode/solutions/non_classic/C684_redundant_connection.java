package com.leetcode.solutions.non_classic;

import java.util.*;

/**
 * this problem is about using union find algorithm
 */
public class C684_redundant_connection {

    /*
    Solution 1, easier to understand, neat
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] sets = new int[edges.length + 1];

        for(int[] edge : edges) {
            int u = find(sets, edge[0]);
            int v = find(sets, edge[1]);
            if(u == v)
                return edge;
            sets[u] = v;
        }

        return new int[]{};
    }

    int find(int[] sets, int v) {
        return sets[v] == 0 ? v : find(sets, sets[v]);
    }

    /*
    Solution 2, longer code
     */
    public int[] findRedundantConnection_2(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);

        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0] - 1, edge[1] - 1)) return edge;
        }

        throw new IllegalArgumentException();
    }

    static class DisjointSet {

        private int[] parent;
        private byte[] rank;

        public DisjointSet(int n) {
            if (n < 0) throw new IllegalArgumentException();
            parent = new int[n];
            rank = new byte[n];
        }

        public int find(int x) {
            if (parent[x] == 0) return x;
            return parent[x] = find(parent[x]); // Path compression by halving.
        }

        // Return false if x, y are connected.
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;

            // Make root of smaller rank point to root of larger rank.
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }

            return true;
        }
    }
}
