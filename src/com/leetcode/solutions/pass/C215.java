package com.leetcode.solutions.pass;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class C215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums)
            queue.add(num);

        int res = nums[0];
        k = nums.length - k + 1;
        while(k > 0) {
            res = queue.poll();
            k -= 1;
        }

        return res;
    }

    public static void main(String[] strings) {
        C215 c = new C215();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(c.findKthLargest(nums, 2));
    }
}
