package com.leetcode.solutions.discussions;

import java.util.Arrays;

public class C16 {

    // this solution exceed the time limit
//    public int threeSumClosest(int[] nums, int target) {
//        if(nums == null)
//            return 0;
//        if (nums.length < 3) {
//            int sum = 0;
//            for (int num : nums)
//                sum += num;
//
//            return sum;
//        }
//
//        Arrays.sort(nums);
//
//        List<Integer> list = new ArrayList<>();
//        int close = nums[0] + nums[1] + nums[2];
//        close = helper(list, target, close, nums, 0);
//        return close;
//    }
//
//    private int helper(List<Integer> list, int target, int close, int[] nums, int i) {
//        if (list.size() == 3) {
//            int sum = 0;
//            for (int num : list)
//                sum += num;
//
//            if (Math.abs(sum - target) < Math.abs(close - target)) {
//                close = sum;
//                return close;
//            }
//        } else {
//            for (int j = i; j < nums.length; j ++) {
//                list.add(nums[j]);
//                close = helper(list, target, close, nums, j + 1);
//                list.remove(list.size() - 1);
//            }
//        }
//
//        return close;
//    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null)
            return 0;
        if (nums.length < 3) {
            int sum = 0;
            for (int num : nums)
                sum += num;

            return sum;
        }

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return sum;

                if (Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;

                // here is the tricky part
                if (sum > target)
                    k--;
                else
                    j++;
            }
        }

        return closest;
    }

    public static void main(String[] strings) {
        C16 c = new C16();
        System.out.println(c.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }
}
