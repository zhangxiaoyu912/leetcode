package com.leetcode.solutions.discussions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class C179 {

    /**
     * this problem needs some out of box thinking :
     * 1. don't afraid to use Java utility
     * 2. problem can be much simpler by another angle
     */

    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i ++)
            array[i] = String.valueOf(nums[i]);

        // notice here we need a decending order
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder res = new StringBuilder();
        for (String str : array)
            res.append(str);

        // notice this is a good property of StringBuilder
        while(res.charAt(0)=='0'&&res.length()>1)
            res.deleteCharAt(0);

        return res.toString();
    }

    public static void main(String[] strs) {
        C179 c = new C179();
        int[] nums = new int[]{0, 0, 0};
        System.out.println(c.largestNumber(nums));
    }
}
