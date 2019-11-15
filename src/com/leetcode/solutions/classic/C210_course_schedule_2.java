package com.leetcode.solutions.classic;

import java.util.LinkedList;

public class C210_course_schedule_2 {

    /*
    Solution 1: this is BFS solution, easy to understand
     */
    // topological sort
    // https://www.youtube.com/watch?v=n_yl2a6n7nM
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        //if there is no prerequisites, return a sequence of courses
        if(len == 0){
            int[] res = new int[numCourses];
            for(int m=0; m<numCourses; m++){
                res[m]=m;
            }
            return res;
        }

        //records the number of prerequisites each course (0,...,numCourses-1) requires
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }

        // stores courses that have no prerequisites in queue
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        int numNoPre = queue.size();// fixme: the tricky place, to track the final course which are cleaned to be independent

        //initialize result
        int[] result = new int[numCourses];
        int j=0;

        while(!queue.isEmpty()){
            int c = queue.remove();
            result[j++]=c;

            // use pCounter to record dependency degree, original data stored in prerequisites
            for(int i=0; i<len; i++){
                if(prerequisites[i][1]==c){// c is prerequisites[i][1]'s dependency
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){// when this, course prerequisites[i][0] doesn't have depen
                        queue.add(prerequisites[i][0]);// add it to the queue
                        numNoPre++;
                    }
                }

            }
        }

        // return result
        if(numNoPre==numCourses){// means all coursed complete fixme: means all number of course has clean dependency chain is equal to numCourses, means all clean
            return result;
        }else{
            return new int[0];
        }
    }
}
