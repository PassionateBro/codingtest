package com.learn2;

/**
 * @describtion: 629. K个逆序对数组
 * @author: CaiJm
 * @Date: 2021-11-11 9:08
 */
public class KInversePairs {
    public int kInversePairs(int n, int k) {
        if (k == 0) return 1;
        int mod = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i - 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j - i >= 0) dp[i][j] -= dp[i - 1][j - i];

                if (dp[i][j] >= mod) dp[i][j] -= mod;
                else if (dp[i][j] < 0) dp[i][j] += mod;
            }
        }
        return dp[n][k];
    }
}
