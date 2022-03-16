package com.learnnew5;

/**
 * @describtion: 2104. 子数组范围和
 * @author: CaiJm
 * @Date: 2022-03-04 9:19
 */
public class SubArrayRanges {
    public long subArrayRanges(int[] nums) {
        int n = nums.length, max = 0, min = 0;
        long res = 0;
        // 枚举子数组左边界
        for ( int i = 0; i < n; i++ ) {
            max = nums[i];
            min = nums[i];
            // 枚举有边界
            for ( int j = i+1; j < n; j++ ) {
                // 维护min max
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += (max-min);
            }
        }
        return res;
    }
}
