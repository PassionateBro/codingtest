package com.learn;

/**
 * @describtion: 1456. 定长子串中元音的最大数目
 * @author: CaiJm
 * @Date: 2021-09-01 10:17
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {
        int len = s.length();
        int[] dp = new int[len];
        int num = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < k; i++) {
            char ch = chars[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                num++;
            }
        }
        dp[k - 1] = num;
        for (int i = k; i < len; i++) {
            char ch = chars[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                num++;
            }
            int head = i - k;
            char chHead = chars[head];
            if (chHead == 'a' || chHead == 'e' || chHead == 'i' || chHead == 'o' || chHead == 'u') {
                num--;
            }
            dp[i] = num;
        }
        int res = 0;
        for (int i = k - 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
