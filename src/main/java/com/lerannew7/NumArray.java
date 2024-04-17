package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-18 10:31
 */
public class NumArray {
    private int[] pre;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (left == 0) return pre[right];
        return pre[right] - pre[left - 1];
    }
}
