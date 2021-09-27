package com.dongtaiguihua;

/**
 * @describtion: 516. 最长回文子序列
 * @author: CaiJm
 * @Date: 2021-08-30 11:13
 */
public class LongestPalindromeSubseq {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (s.charAt(i-1) == s.charAt(j-1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len][len] == 0 ? 1 : dp[len][len];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("aa"));
    }
}
