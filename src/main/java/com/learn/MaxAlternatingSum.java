package com.learn;

/**
 * @describtion: 1911. 最大子序列交替和
 * @author: CaiJm
 * @Date: 2021-10-14 10:14
 */
public class MaxAlternatingSum {
    public static long maxAlternatingSum(int[] nums) {
        long m = 0;
        boolean big = true;
        if (nums.length == 1) return nums[0];
        if (nums[0] > nums[1]) {
            m = nums[0];
            big = false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (big) {
                if (nums[i - 1] <= nums[i] && nums[i] > nums[i + 1]) {
                    m += nums[i];
                    big = false;
                }
            } else {
                if (nums[i - 1] >= nums[i] && nums[i] < nums[i + 1]) {
                    m -= nums[i];
                    big = true;
                }
            }
        }
        if (big) {
            m += nums[nums.length - 1];
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[]{7,1,1,2,4}));
    }
}
