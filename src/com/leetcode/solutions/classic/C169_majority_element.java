package com.leetcode.solutions.classic;

import java.util.Arrays;

public class C169_majority_element {

    /*
    Solution 1, O(n)
     */
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }

    /*
    Solution 2, O(nlgn)
     */
    // using a array is better than map on time wise and storage wise
    public int majorityElement_2(int[] num) {
        if(num.length==1){
            return num[0];
        }

        Arrays.sort(num);

        int prev=num[0];
        int count=1;
        for(int i=1; i<num.length; i++){
            if(num[i] == prev){
                count++;
                if(count > num.length/2) return num[i];
            }else{
                count=1;
                prev = num[i];
            }
        }

        return 0;
    }

//     public int majorityElement(int[] nums) {
//         if (nums == null || nums.length == 0)
//             return 0;

//         Map<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             if (!map.containsKey(num))
//                 map.put(num, 1);
//             else
//                 map.put(num, map.get(num) + 1);
//         }

//         int max = Integer.MIN_VALUE;
//         int res = nums[0];
//         for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
//             if (entry.getValue() > max) {
//                 max = entry.getValue();
//                 res = entry.getKey();
//             }
//         }

//         return res;
//     }
}
