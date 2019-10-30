package com.leetcode.solutions.discussions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class C239_Sliding_Window_Maximum {

    // the first thought is using PriorityQueue, but keep in mind it is just a mini heap only

    // this can only return minimum of sliding window and cannot be extended to max value
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] res = new int[nums.length - k + 1];
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        for (int i = 0; i < k; i ++) {
//            q.add(nums[i]);
//        }
//        res[0] = q.poll();
//
//        for (int i = k; i < nums.length; i ++) {
//            q.remove(nums[i - k]);
//            q.add(i);
//            res[i - k + 1] = q.poll();
//        }
//
//        return res;
//    }

    /*
    Solution 1, implement priority queue equal logic for this problem, cannot get min in the same time
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[0];

        int[] result = new int[nums.length-k+1];

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int i=0; i<nums.length; i++){
            // for index not in sliding window, remove it
            if(!deque.isEmpty()&&deque.peekFirst()==i-k)
                deque.poll();

            // if every element in deque is smaller than nums[i], all element got removed
            // if the nums[i] is smaller than the largest in deque, rest except largest got removed except the largest
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }

            // nums[i] will be the tail always, combine this with the step above
            deque.offer(i);

            // only start from i + 1 - k starting add element to result
            if(i+1>=k)
                result[i+1-k]=nums[deque.peek()];
        }

        return result;
    }

    /*
    Solution 2, same think
    */
    public int[] maxSlidingWindow_2(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
