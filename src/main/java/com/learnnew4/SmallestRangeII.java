package com.learnnew4;

import java.util.Arrays;

/**
 * @describtion: 910. 最小差值 II
 * @author: CaiJm
 * @Date: 2022-02-08 16:03
 */
public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        int res = max - min;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i], b = nums[i + 1];
            int high = Math.max(max - k, a + k);
            int low = Math.min(min + k, b - k);
            res = Math.min(res, high - low);
        }
        return res;
    }
}
