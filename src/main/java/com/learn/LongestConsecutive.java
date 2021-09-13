package com.learn;

import java.util.HashSet;

/**
 * @describtion: 128. 最长连续序列
 * @author: CaiJm
 * @Date: 2021-09-08 10:30
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        HashSet<Integer> objects = new HashSet<>();
        for (int i = 0; i < len; i++) {
            objects.add(nums[i]);
        }
        int nowLen = 0;
        for (int num : nums) {
            if (!objects.contains(num - 1)) {
                int tempLen = num;
                while (objects.contains(tempLen + 1)) {
                    tempLen++;
                }
                nowLen = Math.max(tempLen - num + 1, nowLen);
            }
        }
        return nowLen;
    }

    public static void main(String[] args) {
        int h,k;
        h = (k = 2)^2;
        System.out.println(h + " " + k);
    }
}
