package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-08 15:09
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
