package com.lerannew7;

/**
 * @describtion: 121. 买卖股票的最佳时机
 * @author: CaiJm
 * @Date: 2023-02-20 9:46
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int price = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                price = Math.max(prices[i] - min, price);
            }
            min = Math.min(min, prices[i]);
        }
        return price;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,1,5,3,6,4};
        maxProfit(a);
    }
}
