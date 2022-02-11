package com.learnnew4;

/**
 * @describtion: 2006. 差的绝对值为 K 的数对数目
 * @author: CaiJm
 * @Date: 2022-02-09 9:24
 */
public class CountKDifference {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) res++;
            }
        }
        return res;
    }
}
