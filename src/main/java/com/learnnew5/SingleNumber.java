package com.learnnew5;

/**
 * @describtion: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @author: CaiJm
 * @Date: 2022-02-16 10:56
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] dp = new int[32];
        for (int num : nums) {
            int idx = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    dp[idx]++;
                }
                num >>= 1;
                idx++;
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = dp[i] % 3;
            if (dp[i] != 0) {
                res += Math.pow(2.0, i);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,1,6,1};
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones^num & ~twos;
            twos = twos^num & ~ones;
        }
    }
}
