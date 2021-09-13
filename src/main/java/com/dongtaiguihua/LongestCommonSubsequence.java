package com.dongtaiguihua;

/**
 * @describtion: 1143. 最长公共子序列
 * @author: CaiJm
 * @Date: 2021-08-26 10:01
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len = text1.length();
        int len2 = text2.length();
        int max = 0;
        int[][] dp = new int[len + 1][len2 + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j < len; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
