package com.learnnew5;

/**
 * @describtion: 540. 有序数组中的单一元素
 * @author: CaiJm
 * @Date: 2022-02-14 13:43
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }
}
