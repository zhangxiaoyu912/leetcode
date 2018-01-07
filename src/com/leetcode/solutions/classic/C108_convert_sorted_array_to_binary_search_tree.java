package com.leetcode.solutions.classic;

import java.util.Arrays;

public class C108_convert_sorted_array_to_binary_search_tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;

        int len = nums.length;
        if (len == 0)
            return null;
        else if (len == 1)
            return new TreeNode(nums[0]);
        else if (len == 2) {
            TreeNode root = new TreeNode(nums[1]);
            root.left = new TreeNode(nums[0]);
            return root;
        }

        int mid = len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] leftArray = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, len);
        root.left = sortedArrayToBST(leftArray);
        root.right = sortedArrayToBST(rightArray);

        return root;
    }

    public static void main(String[] strings) {
        int[] array = new int[]{-10,-3,0,5,9};
        C108_convert_sorted_array_to_binary_search_tree c = new C108_convert_sorted_array_to_binary_search_tree();
        TreeNode node = c.sortedArrayToBST(array);
        System.out.println(node);
    }
}
