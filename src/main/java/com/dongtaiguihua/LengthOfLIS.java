package com.dongtaiguihua;

import java.util.Arrays;

/**
 * @describtion: 300. 最长递增子序列
 * @author: CaiJm
 * @Date: 2021-08-25 10:40
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        new LengthOfLIS().lengthOfLIS(new int[]{1, 2, 3});
    }
}
