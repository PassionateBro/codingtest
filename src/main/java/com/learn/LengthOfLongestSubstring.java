package com.learn;

/**
 * @describtion: 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author: CaiJm
 * @Date: 2021-09-24 16:08
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 0;
        String[] dp = new String[s.length()];
        dp[0] = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            int idx = dp[i - 1].indexOf(s.substring(i, i + 1));
            if (idx != -1) {
                dp[i] = dp[i - 1].substring(idx + 1) + s.substring(i, i + 1);
            } else {
                dp[i] = dp[i - 1] + s.substring(i, i + 1);
            }
            max = Math.max(max, dp[i].length());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
