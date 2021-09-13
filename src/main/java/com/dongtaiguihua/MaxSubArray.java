package com.dongtaiguihua;

/**
 * @describtion: 53. 最大子序和
 * @author: CaiJm
 * @Date: 2021-08-26 10:30
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len + 1];
        if (len == 1) {
            return nums[0];
        }
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
            dp[i] = Math.max(dp[i], nums[i - 1]);
        }
        int max = dp[1];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, -1}));
    }
}
