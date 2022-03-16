package com.learnnew5;

import java.util.HashSet;

/**
 * @describtion: 1060. 有序数组中的缺失元素
 * @author: CaiJm
 * @Date: 2022-03-08 14:08
 */
public class MissingElement {
    public static int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            int defect = nums[mid] - nums[left] - (mid - left);
            if (defect >= k) {
                right = mid;
            } else {
                left = mid;
                k -= defect;
            }
        }
        int defect = nums[right] - nums[left] - (right - left);
        if (k > defect) {
            return nums[right] - defect + k;
        }
        int i = nums[left];
        HashSet<Integer> set = new HashSet<>();
        for (int j = left; j <= right; j++) {
            set.add(nums[j]);
        }
        for (int j = i; j <= nums[nums.length-1] + k+1; j++) {
            if (set.contains(j)) continue;
            k--;
            if (k == 0) return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] s=  new int[]{1,2,4};
        missingElement(s,6);
    }
}
