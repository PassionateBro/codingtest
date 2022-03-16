package com.learnnew5;

/**
 * @describtion: 42. 接雨水
 * @author: CaiJm
 * @Date: 2022-03-14 14:06
 */
public class Trap {
    public int trap(int[] height) {
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            dpLeft[i] = Math.max(dpLeft[i - 1], height[i - 1]);
            dpRight[height.length - 1 - i] = Math.max(dpRight[height.length - i], height[height.length - i]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (dpLeft[i] > height[i] && dpRight[i] > height[i]) {
                res += Math.min(dpLeft[i], dpRight[i]) - height[i];
            }
        }
        return res;
    }
}
