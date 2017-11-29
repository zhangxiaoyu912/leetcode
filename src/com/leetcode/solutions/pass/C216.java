package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */

public class C216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, n, 0, current, list, k);

        return list;
    }

    private void combinationSum(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> list, int k) {
        // make a deep copy !!!
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(current);
            if (temp.size() == k)
                list.add(temp);

            return;
        }

        for (int i = j; i< candidates.length; i ++) {
            if (candidates[i] > target)
                return;

            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i + 1, current, list, k);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] strings) {
        C216 c = new C216();
        List<List<Integer>> lists = c.combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            System.out.println("--------------------");
            for (int num : list)
                System.out.println(num);
        }
    }
}
