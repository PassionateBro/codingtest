package com.dongtaiguihua;

/**
 * @describtion: 647. 回文子串
 * @author: CaiJm
 * @Date: 2021-08-30 9:59
 */
public class
CountSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len - 1; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }

            }
        }
        return res;
    }
}
