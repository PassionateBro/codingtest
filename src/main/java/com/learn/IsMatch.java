package com.learn;

/**
 * @describtion: 44. 通配符匹配
 * @author: CaiJm
 * @Date: 2021-10-13 10:08
 */
public class IsMatch {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "*"));
//        System.out.println(isMatch("adceb", "a*b"));
//        System.out.println(isMatch("acdcb", "a*c?b"));
        System.out.println(isMatch("", "***"));
    }
}
