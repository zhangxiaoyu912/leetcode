package com.leetcode.solutions;

public class C33_search_in_roated_sorted_array {

    // fixme: this solution works better and much shorter, very neat. TIPS: find the smallest and use %
    int search(int A[], int target) {
        int lo=0,hi=A.length-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=A.length-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){// fixme: the traditional binary search is <=, otherwise infite loop
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%(A.length - 1);
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }

//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0)
//            return -1;
//
//        if (nums.length == 1)
//            return nums[0] == target ? 0 : -1;
//
//        int index = 0;
//        int max = nums[index];
//        int factor = 0;
//        while (index < nums.length && nums[index] >= max) {
//            max = nums[index];
//            index += Math.pow(2, factor);
//            factor ++;
//        }
//        index -= Math.pow(2, factor - 1);
//
//        while (index < nums.length && nums[index] >= max) {
//            max = nums[index];
//            index ++;
//        }
//        index --;
//
//        int high = index;
//        int low = index == nums.length - 1 ? 0 : index + 1;
//
//        while (low - (index + 1) < high - 1 + (nums.length - index - 1)) {
//            int mid = ((low + high) % nums.length) / 2;
//            if (nums[mid] > target)
//                high = mid;
//            else if (nums[mid] < target)
//                low = mid;
//            else
//                return mid;
//        }
//
//        return -1;
//    }

    public static void main(String[] strings) {
        C33_search_in_roated_sorted_array c = new C33_search_in_roated_sorted_array();
        System.out.println(c.search(new int[]{4,5,6,7,0,1,2}, 7));
    }
}
