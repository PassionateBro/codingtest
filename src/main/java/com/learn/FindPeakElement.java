package com.learn;

/**
 * @describtion: 162. 寻找峰值
 *
 *
 * @author: CaiJm
 * @Date: 2021-09-22 9:40
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
