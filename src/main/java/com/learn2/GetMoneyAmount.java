package com.learn2;

/**
 * @describtion: 375. 猜数字大小 II
 * @author: CaiJm
 * @Date: 2021-11-12 9:15
 */
public class GetMoneyAmount {
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n-1; i >=1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        getMoneyAmount(10);
    }
}
