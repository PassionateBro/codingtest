package com.learnnew3;

/**
 * @describtion: 747. 至少是其他数字两倍的最大数
 * @author: CaiJm
 * @Date: 2022-01-13 13:50
 */
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        int max = nums[0];
        int subMax = nums[0] / 2 - 1;
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                subMax = max;
                max = num;
                idx = i;
            } else {
                if (num > subMax) {
                    subMax = num;
                }
            }
        }
        return subMax * 2 <= max ? idx : -1;
    }
}
