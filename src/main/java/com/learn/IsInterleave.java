package com.learn;

/**
 * @describtion: 97. 交错字符串
 * @author: CaiJm
 * @Date: 2021-08-31 9:24
 */
public class IsInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1 && (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)); i++) dp[i][0] = true;
        for (int i = 1; i <= len2 && (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)); i++) dp[0][i] = true;
        for (int i = 1; i <= s1.length(); i++) { //s1
            for (int j = 1; j <= s2.length(); j++) { //s2

                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
