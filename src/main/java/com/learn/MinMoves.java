package com.learn;


/**
 * @describtion: 453. 最小操作次数使数组元素相等
 * @author: CaiJm
 * @Date: 2021-10-20 9:13
 */
public class MinMoves {
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
