package com.learn;

import java.util.Arrays;

/**
 * @describtion: 594. 最长和谐子序列
 * @author: CaiJm
 * @Date: 2021-10-12 17:48
 */
public class FindLHS {
    public static int findLHS(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        int tempIdx = 0;
        int temp = nums[0];
        int begin = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != temp) {
                if (Math.abs(nums[i] - temp) == 1) {
                    temp = nums[i];
                    tempIdx = i;
                    for (; i < nums.length; i++) {
                        if (temp != nums[i]) {
                            begin = tempIdx;
                            temp = nums[i-1];
                            break;
                        }
                    }
                    max = Math.max(max, i - begin);
                } else {
                    temp = nums[i];
                    begin = i;
                    i++;
                }
            } else {
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        findLHS(new int[]{1,2,3,4});
    }
}
