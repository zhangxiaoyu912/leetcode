package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// it is basically a brute force solution optimization. HashMap cannot help at this point.
// In nature it is brute force, but sorting first make it a better, plus
// it is easier to handle duplicate after sorting, then 5Sum, 6Sum are all possible, similar idea
public class C18_4_sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length<4)
            return result;

        Arrays.sort(nums);

        // 4 moving target, p, i, j, k. While p and i as out loop, and j and k move from two side to meet in middle
        // the logic is based on array is sorted
        // avoid duplicate is important trick inside
        for (int p = 0; p < nums.length - 3; p++) {
            if (p != 0 && nums[p] == nums[p - 1])// to handle the duplicate of 'p' itself
                continue;

            if (p == 0 || nums[p] > nums[p - 1]) {
                for (int i = p + 1; i < nums.length - 2; i++) {
                    if (i != p + 1 && nums[i] == nums[i - 1])// to handle duplicate of 'i' itself
                        continue;

                    int j = i + 1;
                    int k = nums.length - 1;

                    while (j < k) {
                        if (nums[p] + nums[i] + nums[j] + nums[k] == target) {
                            List<Integer> l = new ArrayList<>();
                            l.add(nums[p]);
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            result.add(l);

                            j++;
                            k--;

                            //handle duplicate of 'j' itself and 'k' itself here
                            while (j < k && nums[j] == nums[j - 1])
                                j++;
                            while (j < k && nums[k] == nums[k + 1])
                                k--;

                            // similar logic as C15 and C16 to move j and k
                        } else if (nums[p] + nums[i] + nums[j] + nums[k] < target) {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] strings) {
        C18_4_sum c = new C18_4_sum();
        System.out.println(c.fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
    }
}
