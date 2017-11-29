package com.leetcode.solutions.checked.discussion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length<4)
            return result;

        Arrays.sort(nums);

        for (int p = 0; p < nums.length - 3; p++) {
            if (p != 0 && nums[p] == nums[p - 1])
                continue;

            if (p == 0 || nums[p] > nums[p - 1]) {
                for (int i = p + 1; i < nums.length - 2; i++) {
                    if (i != p + 1 && nums[i] == nums[i - 1])
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

                            //handle duplicate here
                            while (j < k && nums[j] == nums[j - 1])
                                j++;
                            while (j < k && nums[k] == nums[k + 1])
                                k--;

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
        C18 c = new C18();
        System.out.println(c.fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
    }
}
