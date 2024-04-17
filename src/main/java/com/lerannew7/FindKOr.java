package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-06 9:43
 */
public class FindKOr {
    public static int findKOr(int[] nums, int k) {
        int[] dp = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int n = 0;
            while (a != 0) {
                int b = a & 1;
                if (1 == b) {
                    // 有1
                    dp[n] += 1;
                }
                n++;
                a = a >> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= k) {
                res += (int) Math.pow(2, i);
            }
        }
        return res;
    }


}
