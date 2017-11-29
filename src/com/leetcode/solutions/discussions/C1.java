package com.leetcode.solutions.discussions;

import java.util.HashMap;
import java.util.Map;

public class C1 {

    // this solution is good since it only loop once
    // it will avoid the case duplicate number like [3, 3] with sum is 6
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[]{0, 0};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                int[] res = new int[]{map.get(nums[i]), i};
                return res;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[]{0, 0};
    }
}
