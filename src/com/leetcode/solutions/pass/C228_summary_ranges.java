package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;

public class C228_summary_ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;

        int l = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            } else {
                String str;
                if (l == nums[i - 1])
                    str = String.valueOf(l);
                else
                    str = l + "->" + nums[i - 1];

                list.add(str);
                l = nums[i];
            }
        }

        if (l == nums[nums.length - 1])
            list.add(l+"");
        else
            list.add(l + "->" + nums[nums.length - 1]);

        return list;
    }
}
