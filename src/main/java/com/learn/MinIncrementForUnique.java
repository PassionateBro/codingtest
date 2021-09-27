package com.learn;


import java.util.Arrays;
import java.util.TreeSet;

/**
 * @describtion: 945. 使数组唯一的最小增量
 * @author: CaiJm
 * @Date: 2021-09-14 9:07
 */
public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int times = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                times += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return times;
    }
}
