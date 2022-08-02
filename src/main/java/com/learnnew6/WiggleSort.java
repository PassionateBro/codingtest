package com.learnnew6;

import java.util.Arrays;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-06-28 11:07
 */
public class WiggleSort {
    public static void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] rec = Arrays.copyOf(nums, nums.length);
        Arrays.sort(rec);
        int l = len % 2 == 0 ? len / 2 - 1 : len / 2, r = len - 1, index = 0;
        while (index < len) {
            nums[index] = rec[(index & 1) == 0 ? l-- : r--];
            index++;
        }
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3});
    }
}
