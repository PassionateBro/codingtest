package com.dongtaiguihua;

/**
 * @describtion: 583. 两个字符串的删除操作
 * @author: CaiJm
 * @Date: 2021-08-27 9:23
 */
public class MinDistance {
    /**
     * 问题的实质就是找到最长公共子列
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }

    /**
     * 一维解
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceOneDimensional(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            int crr = 0;
            int pre;
            for (int j = 1; j <= len2; j++) {
                pre = crr;
                crr = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = 1 + pre;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return len1 + len2 - 2*dp[len2];
    }
}
