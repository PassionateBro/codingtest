package com.learn;

/**
 * @describtion: 1745. 回文串分割 IV
 * <p>
 * 给你一个字符串s，如果可以将它分割成三个非空回文子字符串，那么返回true，否则返回false。
 * <p>
 * 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
 * @author: CaiJm
 * @Date: 2021-09-26 14:35
 */
public class CheckPartitioning {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (i == j) dp[i][j] = true;
                else if (b && j - i > 1 && dp[i + 1][j - 1]) dp[i][j] = true;
                else if (b && j - i == 1) dp[i][j] = true;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (dp[i][j] && dp[0][i - 1] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge(String s) {
        int len = s.length();
        int begin = 0;
        int end = len - 1;
        while (end - begin >= 1) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPartitioning checkPartitioning = new CheckPartitioning();
        System.out.println(checkPartitioning.checkPartitioning("acab"));
    }
}
