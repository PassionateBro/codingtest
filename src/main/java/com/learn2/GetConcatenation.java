package com.learn2;

/**
 * @describtion: 1929. 数组串联
 * @author: CaiJm
 * @Date: 2021-11-15 16:45
 */
public class GetConcatenation {
    public int[] getConcatenation(int[] nums) {
        int[] ints = new int[nums.length * 2];
        for (int i = 0; i < ints.length; i++) {
            int j = i;
            if (i >= nums.length) {
                j = i - ints.length;
            }
            ints[i] = nums[j];
        }
        return ints;
    }
}
