package com.lerannew7;

import java.util.LinkedList;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-14 9:26
 */
public class MaxArrayValue {
    public long maxArrayValue(int[] nums) {
        long res = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= res) {
                res += nums[i];
            } else {
                res = nums[i];
            }
        }
        return res;
    }
}
