package com.learn;

/**
 * @describtion: 剑指 Offer 63. 股票的最大利润
 * @author: CaiJm
 * @Date: 2021-10-15 14:05
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                buy = Math.min(prices[i], buy);
            } else {
                profit = Math.max(prices[i] - buy, profit);
            }
        }
        return profit;
    }
}
