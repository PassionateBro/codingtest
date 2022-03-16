package com.learnnew5;

/**
 * @describtion: 62. 不同路径
 * @author: CaiJm
 * @Date: 2022-02-28 15:15
 */
public class UniquePaths {
    int res = 0;
    int[][] direct = new int[][]{{0, 1}, {1, 0}};

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
