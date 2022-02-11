package com.learnnew4;

/**
 * @describtion: 713. 乘积小于K的子数组
 * @author: CaiJm
 * @Date: 2022-02-07 10:11
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
