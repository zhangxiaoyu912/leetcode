package com.leetcode.solutions.classic;

public class C26_remove_duplicated_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        // the solution from the discussion is extremly simple
        if (nums.length < 2)
            return nums.length;

        int j = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] == nums[j]) {
                i++;
            } else {
                j++;
                nums[j] = nums[i];
                i++;
            }
        }

        return j + 1;

//         if (nums == null || nums.length == 0)
//             return 0;

//         int curr = 0;
//         int count = 1;
//         for (int i = 1; i < nums.length; i ++) {
//             if (nums[i] > nums[curr]) {
//                 count ++;
//                 curr ++;
//             } else {
//                 int j = i;

//                 while (j + 1 < nums.length && nums[j] == nums[i])
//                     j ++;

//                 int p = i;
//                 int q = j;
//                 while (q < nums.length) {
//                     nums[p] = nums[q];
//                     p++;
//                     q++;
//                 }

//                 if (nums[j] > nums[i]) {
//                     count++;
//                     i = j - 1;
//                     curr = j - 1;
//                 }
//             }
//         }

//         return count;
    }

    public static void main(String[] strings) {
        C26_remove_duplicated_from_sorted_array c = new C26_remove_duplicated_from_sorted_array();
        System.out.println(c.removeDuplicates(new int[]{1, 2, 3,3,3,3,3,3,3,6,6,8}));
    }
}
