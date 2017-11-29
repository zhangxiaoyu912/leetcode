package com.leetcode.solutions.discussions;

public class C88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null)
            return;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m -= 1;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n -= 1;
            }
        }

        while (n > 0) {
            nums1[m + n - 1] = nums2[n - 1];
            n -= 1;
        }
    }

    public static void main(String[] strings) {
        C88 c = new C88();
        int[] num1 = new int[]{4,5,6,0,0,0};
        int[] num2 = new int[]{1,2,3};
        c.merge(num1, 3, num2, 3);
        System.out.println(num1);
    }
}
