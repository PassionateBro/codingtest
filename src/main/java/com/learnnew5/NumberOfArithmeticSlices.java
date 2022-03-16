package com.learnnew5;

/**
 * @describtion: 413. 等差数列划分
 * @author: CaiJm
 * @Date: 2022-03-01 9:40
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 1) return 0;
        int res = 0;
        int conti = 1;
        int[] dp = new int[nums.length];
        dp[1] = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] - nums[i - 1];
            if (dp[i] == dp[i - 1]) {
                conti ++;
            } else {
                if (conti >= 3) {
                    res += calculate(conti);
                }
                conti = 2;
            }
        }
        if (conti >= 3) {
            res += calculate(conti);
        }
        return res;
    }

    private int calculate(int num) {
        int res = 0;
        for (int i = 3; i <= num; i++) {
            res += num - i +1;
        }
        return res;
    }
}
