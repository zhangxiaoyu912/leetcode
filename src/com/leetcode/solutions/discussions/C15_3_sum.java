package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C15_3_sum {

    // this solution doesn't have much overlap with 'Two Sum', but it
    // 1. sort the array first
    // 2. has logic to handle duplicate, combine with the sorting power
    // 3. it is n^2, so it is kind of brute force way, but simple
    // again, the sorting makes lots of things much easier
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;

                        // < 0 means the result needs to be bigger, hence j++
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                        // otherwise it is > 0, means the results needs to be smaller, hence k--
                    }else{
                        k--;
                    }
                }
            }

        }

        return result;
    }

    // this is also n^2, since for each i, twoSum will loop the rest array twice for sure
    // it costs more than the best solution, since it loop the rest twice instead of once
    // this solution kind of reuse the code from C1(sum two) and still time exceed
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums == null || nums.length < 3)
//            return result;
//
//        Arrays.sort(nums);
//        Set<List<Integer>> set = new HashSet<>();
//        List<Integer> list;
//        for (int i = 0; i < nums.length; i ++) {
//            Set<int[]> sum2Set = twoSum(nums, i + 1, 0 - nums[i]);
//            for (int[] sum2 : sum2Set) {
//                list = new ArrayList<>();
//                list.add(nums[i]);
//                list.add(nums[sum2[0]]);
//                list.add(nums[sum2[1]]);
//                set.add(list);
//            }
//        }
//
//        for (List<Integer> l : set)
//            result.add(l);
//
//        return result;
//    }
//
//    public Set<int[]> twoSum(int[] nums, int index, int target) {
//        if (nums == null || nums.length < 2)
//            return new HashSet<>();
//
//        Set<int[]> set = new HashSet<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = index; i < nums.length; i ++) {
//            if (map.containsKey(nums[i])) {
//                int[] res = new int[]{map.get(nums[i]), i};
//                set.add(res);
//            } else {
//                map.put(target - nums[i], i);
//            }
//        }
//
//        return set;
//    }

    // brute force solution, which will work on small set
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        if (nums == null || nums.length < 3)
//            return result;
//
//        Arrays.sort(nums);
//
//        Set<List<Integer>> set = new HashSet<>();
//        helper(set, list, nums, 0);
//        for (List<Integer> l : set)
//            result.add(l);
//        return result;
//    }
//
//    private void helper(Set<List<Integer>> set, List<Integer> list, int[] nums, int i) {
//        if (list.size() == 3) {
//            int sum = 0;
//            for (int num : list)
//                sum += num;
//            if (sum != 0)
//                return;
//
//            List<Integer> temp = new ArrayList<>(list);
//            set.add(temp);
//            return;
//        } else {
//            for (int j = i; j < nums.length; j ++) {
//                list.add(nums[j]);
//                helper(set, list, nums, j + 1);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
}
