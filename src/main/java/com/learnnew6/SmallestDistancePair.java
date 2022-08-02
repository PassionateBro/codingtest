package com.learnnew6;

import java.util.Arrays;

/**
 * @describtion: 719. 找出第 K 小的数对距离
 * @author: CaiJm
 * @Date: 2022-06-24 10:23
 */
public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 求比 mid 小的数对
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                cnt += i - sub(i, nums, nums[i] - mid);
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int sub(int n, int[] nums, int target) {
        int begin = 0, end = n;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        smallestDistancePair.smallestDistancePair(new int[]{1, 3, 1}, 1);
    }
}
