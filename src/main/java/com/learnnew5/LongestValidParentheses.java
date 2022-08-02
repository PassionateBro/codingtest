package com.learnnew5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-04-13 11:23
 */

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        if (chars[0] == '(' && chars[1] == ')') {
            dp[1] = 2;
        }
        int max = dp[1];
        for (int i = 2; i < chars.length; i++) {
            if (dp[i - 1] == 0) {
                if (chars[i] == ')' && chars[i - 1] == '(') {
                    dp[i] = 2 + dp[i - 2];
                }
                max = Math.max(dp[i], max);
                continue;
            }
            if (chars[i] == '(') {
                continue;
            }
            // 必须为 ')'
            if (i - dp[i - 1] > 0) {
                if (chars[i - 1 - dp[i - 1]] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - 1 - dp[i - 1] - 1 > 0) {
                        dp[i] += dp[i - 1 - dp[i - 1] - 1];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
