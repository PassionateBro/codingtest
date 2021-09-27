package com.learn;

/**
 * @describtion: 1690. 石子游戏 VII
 * @author: CaiJm
 * @Date: 2021-09-23 16:17
 */
public class StoneGameVII {
    public static int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] sum = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) sum[i][j] = stones[i]; //记录区间和
                else sum[i][j] = stones[j] + sum[i][j - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(sum[i + 1][j] - dp[i + 1][j], sum[i][j - 1] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[]{1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1}));
    }

}
