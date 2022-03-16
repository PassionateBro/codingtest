package com.learnnew5;

/**
 * @describtion: 1004. 最大连续1的个数 III
 * @author: CaiJm
 * @Date: 2022-03-15 15:28
 */
public class LongestOnes {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;
        int tempK = k;
        int res = 0;
        while (left <= right && right < nums.length) {
            if (nums[right] == 1) {
                count++;
                right++;
            } else {
                if (tempK > 0) {
                    tempK--;
                    count++;
                    right++;
                } else {
                    res = Math.max(res, count);
                    while (left < right && nums[left] == 1) {
                        left++;
                        count--;
                    }
                    left++;
                    right++;
                }
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public static void main(String[] args) {
        longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }
}
