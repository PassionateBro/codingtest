package com.learnnew5;

/**
 * @describtion: 213. 打家劫舍 II
 * @author: CaiJm
 * @Date: 2022-02-15 16:32
 */
public class Rob {
    public int rob(int[] nums) {
        if(nums.length == 1){return nums[0];}
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp[0] = 0;//不抢第一个
        dp[1] = nums[1];
        dp2[dp.length-1] = 0;//不抢最后一个
        dp2[dp.length-2] = nums[nums.length-2];
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        for(int i = dp2.length-3;i>=0;i--){
            dp2[i] = Math.max(dp2[i+2]+nums[i],dp2[i+1]);
        }
        return Math.max(dp2[0],dp[dp.length-1]);
    }
}
