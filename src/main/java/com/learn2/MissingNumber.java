package com.learn2;



/**
 * @describtion: 268. 丢失的数字
 * @author: CaiJm
 * @Date: 2021-11-08 15:37
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
