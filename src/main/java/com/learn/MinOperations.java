package com.learn;

import java.util.Arrays;

/**
 * @describtion: 1658. 将 x 减到 0 的最小操作数
 * @author: CaiJm
 * @Date: 2021-09-13 14:28
 */
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int currentSum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            currentSum += nums[right++];
            while (currentSum > sum - x && left < nums.length) {
                currentSum -= nums[left++];
            }
            if (currentSum == sum - x) {
                maxPart = Math.max(maxPart, right - left);
            }
        }
        return maxPart == -1 ? -1 : nums.length - maxPart;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        minOperations.minOperations(new int[]{10, 1, 1, 1, 1, 1}, 5);
    }
}
