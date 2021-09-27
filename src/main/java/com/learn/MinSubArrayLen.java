package com.learn;

/**
 * @describtion: 209. 长度最小的子数组
 * @author: CaiJm
 * @Date: 2021-09-26 11:18
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int[] dp = new int[nums.length];
        int[] dpLen = new int[nums.length];
        dp[0] = nums[0];
        dpLen[0] = 0;
        if (dp[0] >= target) return 1;
        for (int i = 1; i < nums.length; i++) {
            int num = dp[i - 1] + nums[i];
            dp[i] = num;
            dpLen[i] = dpLen[i - 1];
            if (num >= target) {
                int j = dpLen[i];
                num = num - nums[j];
                while (num >= target) {
                    dp[i] = num;
                    dpLen[i] = ++j;
                    num = num - nums[j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dpLen.length; i++) {
            if (dp[i] >= target)
                min = Math.min(min, i - dpLen[i] + 1);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        minSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
