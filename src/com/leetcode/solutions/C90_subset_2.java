package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C90_subset_2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null)
            return null;

        // sort is needed so that duplicate elements will be next to each other
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

        for (int i = nums.length-1; i >= 0; i--) {

            // if nums[i] == nums[i + 1], then can skip this combination, prev will be just enough
            // get existing sets
            // if (i == nums.length - 1), then prev.size() == 0
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                prev = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }

            //add current number to each element of the set
            for (ArrayList<Integer> temp : prev) {
                temp.add(0, nums[i]);
            }

            // if nums[i] == nums[i + 1], then add single ele list doens't make sense
            //add each single number as a set, only if current element is different with previous
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                prev.add(temp);
            }

            //add all set created in this iteration
            for (ArrayList<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }

        //add empty set
        result.add(new ArrayList<Integer>());

        return result;
    }

    public static void main(String[] strings) {
        C90_subset_2 c = new C90_subset_2();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> lists = c.subsetsWithDup(nums);
        System.out.println(lists);
    }
}
