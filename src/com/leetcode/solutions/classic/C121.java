package com.leetcode.solutions.classic;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 */

public class C121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int maxProfit = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < minNum)
                minNum = prices[i];

            if (prices[i] - minNum > maxProfit)
                maxProfit = prices[i] - minNum;
        }

        return maxProfit;

        // obviously too bad, need DP
//        int max = 0;
//        for (int i = prices.length - 1; i >= 0; i --) {
//            for (int j = i - 1; j >= 0; j --) {
//                int diff = prices[i] - prices[j];
//                max = diff > max ? diff : max;
//            }
//        }
//        return max;
    }

    public static void main(String[] strings) {
        C121 c = new C121();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(c.maxProfit(prices));
    }
}
