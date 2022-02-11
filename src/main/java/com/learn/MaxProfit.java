package com.learn;

/**
 * @describtion: 剑指 Offer 63. 股票的最大利润
 * @author: CaiJm
 * @Date: 2021-10-15 14:05
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            max = Math.max(prices[i] - dp[i - 1], max);
        }
        return max;
    }
}
