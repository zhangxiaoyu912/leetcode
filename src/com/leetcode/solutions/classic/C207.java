package com.leetcode.solutions.classic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */

public class C207 {

    // there is also another BFS solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null)
            return false;

        int len = prerequisites.length;
        if (numCourses == 0 || len == 0)
            return true;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i ++) {
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], set);
            }
        }

        int[] visited = new int[numCourses];
        // need a loop since to make sure that each course can finish
        // if any course cannot, return false as whole (cannot finish all courses)
        // (in the end depends on some course doesn't have dependency)
        for (int i = 0; i < numCourses; i ++) {
            if (!dfs(map, visited, i))
                return false;
        }

        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, int[] visited, int i) {
        // if the value has been stored in visited before
        if (visited[i] == -1)
            return false;
        if (visited[i] == 1)
            return true;

        // mark it as -1 since this course need depends on other course
        visited[i] = -1;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (!dfs(map, visited, j))
                    return false;
            }
        }
        // mark it as 1 and store in int[] visited
        // since this course either one of the case :
        //          1. doesn't have any dependency : map.containsKey(i) == false here
        //          2. can finish (in the end dependency chain ends in course without dependency)
        visited[i] = 1;

        return true;
    }
}
