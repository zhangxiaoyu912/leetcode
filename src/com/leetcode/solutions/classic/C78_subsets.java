package com.leetcode.solutions.classic;

import java.util.ArrayList;
import java.util.List;

public class C78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return new ArrayList<>();

        // Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            List<List<Integer>> temp = new ArrayList<>();
            // load all from result to temp
            for (List<Integer> list : result)
                temp.add(new ArrayList<Integer>(list));

            // add nums[i] to each list inside temp
            for (List<Integer> list : temp)
                list.add(nums[i]);

            // add single
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            temp.add(single);

            // for (List<Integer> list : temp) {
            //     if (!result.contains(list))
            //         result.add(list);
            // }
            result.addAll(temp);
        }
        // add empty
        result.add(new ArrayList<>());

        return result;
    }
}
