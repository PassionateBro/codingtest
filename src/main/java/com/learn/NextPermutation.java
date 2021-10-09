package com.learn;

import java.util.Arrays;

/**
 * @describtion: 31. 下一个排列
 * @author: CaiJm
 * @Date: 2021-10-09 15:20
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int min = nums[i];
                int idx = i;
                for (int j = i; j < nums.length; j++) {
                    int temp = nums[j];
                    int tail = nums.length - 1 - (j - i);
                    if (j > tail) continue;
                    nums[j] = nums[tail];
                    nums[tail] = temp;
                }
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        min = nums[j];
                        idx = j;
                    }
                }
                nums[idx] = nums[i - 1];
                nums[i - 1] = min;
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{5, 4, 2, 3, 5, 7});
        System.out.println();
    }
}
