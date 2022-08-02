package com.learnnew5;

import java.util.Arrays;

/**
 * @describtion: 462. 最少移动次数使数组元素相等 II
 * @author: CaiJm
 * @Date: 2022-05-19 15:12
 */
public class MinMoves2 {
    public static int minMoves2(int[] nums) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int num = nums[nums.length / 2];
        int res = 0;
        for (int a : nums) {
            res += Math.abs(a - num);
        }
        return res;
    }

    public static void main(String[] args) {
        minMoves2(new int[]{1,2,3});
    }
}
