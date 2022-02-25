package com.learnnew5;

import java.util.Arrays;

/**
 * @describtion: 剑指 Offer 60. n个骰子的点数
 * @author: CaiJm
 * @Date: 2022-02-23 14:25
 */
public class DicesProbability {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;

    }

    private void dfs(double[] dp, int n, int x, int sum) {
        if (x == 0) {
            dp[sum - (n - 1) - 1] += 1 * 1.0 / Math.pow(6, n);
            return;
        }
        for (int i = 1; i <= 6; i++) {
            dfs(dp, n, x - 1, sum + i);
        }
    }
}
