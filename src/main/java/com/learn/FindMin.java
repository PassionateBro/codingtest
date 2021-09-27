package com.learn;

/**
 * @describtion: 153. 寻找旋转排序数组中的最小值
 * @author: CaiJm
 * @Date: 2021-09-26 16:42
 */
public class FindMin {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[j]) i = mid + 1;
            else j = mid;
        }
        return nums[j];
    }
}
