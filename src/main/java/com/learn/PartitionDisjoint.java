package com.learn;

/**
 * @describtion: 915. 分割数组
 * @author: CaiJm
 * @Date: 2021-10-08 14:37
 */
public class PartitionDisjoint {

    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int max = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < leftMax) {
                leftMax = max;
                index = i;
            }
        }

        return index + 1;
    }
}
