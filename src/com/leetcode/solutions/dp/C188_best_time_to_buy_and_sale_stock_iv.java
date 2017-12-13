package com.leetcode.solutions.dp;

public class C188_best_time_to_buy_and_sale_stock_iv {
    // the size or dimensions of DP memorized table can be 1D array or 2D array, depends on the problem
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        // in this case, problem become no restrictions of number of trade
        if (k >= len / 2) return quickSolve(prices);

        // have a table to memorize all cases of k (from 1 to n) and j (from 1 to len - 1)
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                // max local profit for fixed k
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                // compare tmpMax with 1 less trade but trade at point of [i-1][j-1] to prices[j]
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
