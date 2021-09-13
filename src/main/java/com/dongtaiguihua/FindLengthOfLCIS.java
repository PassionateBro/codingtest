package com.dongtaiguihua;

import java.util.Arrays;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-08-25 17:10
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            }
        }
        int dpLen = dp.length;
        int res = 0;
        for (int i = 0; i < dpLen; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
