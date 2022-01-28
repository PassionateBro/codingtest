package com.learnnew3;

/**
 * @describtion: 剑指 Offer 57. 和为s的两个数字
 * @author: CaiJm
 * @Date: 2022-01-21 16:40
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) {
                i++;
            } else if (s > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[500000];
    }
}
