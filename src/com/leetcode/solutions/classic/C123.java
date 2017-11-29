package com.leetcode.solutions.classic;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

// https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
public class C123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int total = 0;
        int min = prices[0];
        int[] left = new int[prices.length];
        left[0] = 0;
        for (int i = 1; i < prices.length; i ++) {
            min = prices[i] < min ? prices[i] : min;
            left[i] = prices[i] - min;
        }

        int[] right = new int[prices.length];
        int max = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for (int j = prices.length - 2; j >= 0; j --) {
            max = Math.max(max, prices[j]);
            right[j] = Math.max(right[j + 1], max - prices[j]);
        }

        for (int p = 0; p < left.length; p ++)
            total = Math.max(total, left[p] + right[p]);

        return total;
    }

    public static void main(String[] strings) {
        C123 c = new C123();
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        System.out.println(c.maxProfit(prices));
    }
}
