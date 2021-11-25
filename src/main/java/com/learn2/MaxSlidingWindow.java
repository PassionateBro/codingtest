package com.learn2;


/**
 * @describtion: 剑指 Offer 59 - I. 滑动窗口的最大值
 * @author: CaiJm
 * @Date: 2021-11-17 16:48
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(nums[i], max);
        }
        res[0] = max;
        int idx = 1;
        for (int i = k; i < nums.length; i++) {
            int j = i - k;
            if (nums[i]> max) {
                max = nums[i];
            } else {
                if (nums[j] >= max) {
                    // 重新选举max
                    max = Integer.MIN_VALUE;
                    for (int m = j+1; m <= j + k; m++) {
                        max = Math.max(nums[m], max);
                    }
                }
            }
            res[idx] = max;
            idx++;
        }
        return res;
    }
}
