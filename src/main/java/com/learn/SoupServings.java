package com.learn;

import java.util.Arrays;

/**
 * @describtion: 808. 分汤
 * @author: CaiJm
 * @Date: 2021-10-14 9:45
 */
public class SoupServings {
    public double soupServings(int n) {
        if (n >= 4800) return 1;
        int m = n / 25 + ((n % 25 == 0) ? 0 : 1);
        double[][] dp = new double[m + 1][m + 1];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0.5;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = 0.25 * (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]);
            }
        }
        return dp[m][m];

    }
}
