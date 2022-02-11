package com.learnnew4;

/**
 * @describtion: 剑指 Offer 46. 把数字翻译成字符串
 * @author: CaiJm
 * @Date: 2022-02-09 16:07
 */
public class TranslateNum {
    public int translateNum(int num) {
        if (num < 10) return 1;
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int nums2 = Integer.valueOf(s.substring(0, 2));
        if (nums2 > 25) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }
        for (int i = 2; i < chars.length; i++) {
            int nums = Integer.valueOf(String.valueOf(chars[i - 1]) + String.valueOf(chars[i]));
            if (nums > 25) {
                dp[i] = dp[i - 1];
            } else {
                if (chars[i - 1] == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
