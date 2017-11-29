package com.leetcode.solutions.classic;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class C122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int total = 0;
        int profitMax = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            int diff = prices[i] - prices[i - 1];
            min = prices[i] < min ? prices[i] : min;
            if (diff < 0) {
                total += profitMax;
                profitMax = 0;
                min = prices[i];
            } else {// diff >= 0
                int profit = prices[i] - min;
                profitMax = profit > profitMax ? profit : profitMax;
            }

            if (i == prices.length - 1)
                total += profitMax;
        }

        return total;
    }

    public static void main(String[] strings) {
        C122 c = new C122();
        int[] prices = new int[]{100, 180, 260, 310, 40, 535, 695};
        System.out.println(c.maxProfit(prices));
    }
}
