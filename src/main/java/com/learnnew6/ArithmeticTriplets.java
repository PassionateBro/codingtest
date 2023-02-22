package com.learnnew6;

import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-24 13:51
 */
public class ArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (set.contains(nums[i] + diff) && set.contains(nums[i] + 2 * diff)) {
                res++;
            }
        }
        return res;
    }
}
