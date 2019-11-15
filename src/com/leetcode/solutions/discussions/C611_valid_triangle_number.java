package com.leetcode.solutions.discussions;

import java.util.*;

public class C611_valid_triangle_number {

    /*
    Solution 1, like 3 sum
     */
    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += (right - left);
                    right--;
                }
                else {
                    left++;
                }
            }
        }

        return result;
    }

    /*
    Solution 2: fixme: 1st, the O(n^2) should always think about if sort can help, 2, the brute force recursive call will easily cause stack over flow
     */
    public int triangleNumber_2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        helper(list, nums, new ArrayList<>(), 0);

        return list.size();
    }

    private void helper(List<List<Integer>> list, int[] nums, List<Integer> temp, int i) {
        if (temp.size() == 3 && ( temp.get(0) + temp.get(1) > temp.get(2)) &&  ( temp.get(1) + temp.get(2) > temp.get(0)) && ( temp.get(0) + temp.get(2) > temp.get(1))) {
            ArrayList<Integer> t = new ArrayList<>(temp);
            list.add(t);
            return;
        }

        for (int j = 0; j < nums.length; j ++) {
            temp.add(nums[j]);
            helper(list, nums, temp, i ++);
        }
    }
}
