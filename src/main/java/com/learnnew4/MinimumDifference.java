package com.learnnew4;

import java.util.Arrays;

/**
 * @describtion: 1984. 学生分数的最小差值
 * @author: CaiJm
 * @Date: 2022-02-11 9:24
 */
public class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int begin = 0;
        Arrays.sort(nums);
        for (int i = k - 1; i < nums.length; i++) {
            min = Math.min(nums[i] - nums[begin], min);
            begin++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 4, 1, 7};
        MinimumDifference s = new MinimumDifference();
        s.minimumDifference(a, 2);
    }
}
