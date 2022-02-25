package com.learnnew5;

/**
 * @describtion: 55. 跳跃游戏
 * @author: CaiJm
 * @Date: 2022-02-15 17:22
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (dp[0] == 0) return false;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if (dp[i - 1] < i) {
                return false;
            }
        }
        return dp[nums.length - 1] > 0;
    }
}
