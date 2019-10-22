package com.leetcode.solutions.classic;

public class C154_find_minmum_in_roated_sorted_array_2 {

    // better solution with all binary search
    public int findMin(int[] num) {
        return findMin(num, 0, num.length-1);
    }

    public int findMin(int[] num, int left, int right){
        if(right==left){
            return num[left];
        }
        if(right == left +1){
            return Math.min(num[left], num[right]);
        }
        // 3 3 1 3 3 3

        int middle = (right-left)/2 + left;
        // already sorted
        if(num[right] > num[left]){
            return num[left];
            //right shift one
        }else if(num[right] == num[left]){
            return findMin(num, left+1, right);// this is somehow also a linear search, so below solution is easier to understand
            //go right
        }else if(num[middle] >= num[left]){
            return findMin(num, middle, right);
            //go left
        }else{
            return findMin(num, left, middle);
        }
    }

    // this solution contains linear searh
//    public int findMin(int[] nums) {
//        int low = 0;
//        int high = nums.length - 1;
//        while (low < high && nums[low] >= nums[high]) {
//            while (high - 1 > low && nums[high - 1] == nums[high])
//                high --;
//
//            while (low + 1 < high && nums[low + 1] == nums[low])
//                low ++;
//
//            int mid = (low + high) / 2;
//            if (nums[mid] < nums[high])
//                high = mid;
//            else
//                low = mid + 1;
//        }
//        return nums[low];
//    }
}
