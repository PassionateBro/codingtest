package com.learnnew6;

import java.util.Arrays;

/**
 * @describtion: 462. 最少移动次数使数组元素相等 II
 * @author: CaiJm
 * @Date: 2022-06-22 10:06
 */
public class MinMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = nums[0], r = nums[nums.length - 1];
        int tempRes = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = calculate(mid, nums), resb = calculate(mid + 1, nums);
            if (resb < res) {
                l = mid + 1;
            } else {
                r = mid - 1;
                tempRes = res;
            }
        }
        return tempRes;
    }

    private int calculate(int mid, int[] nums) {
        int res = 0;
        for (int x : nums) {
            res += Math.abs(mid - x);
        }
        return res;
    }

    public static void main(String[] args) {
        MinMoves2 sw = new MinMoves2();
        sw.minMoves2(new int[]{1, 2, 5, 8, 0});
    }
}
