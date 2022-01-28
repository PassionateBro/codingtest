package com.learnnew4;

/**
 * @describtion: 33. 搜索旋转排序数组
 * @author: CaiJm
 * @Date: 2022-01-26 14:20
 */
public class Search {
    public static int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        int mid = 0;
        if (nums.length == 0) return -1;
        if (nums[begin] == target) return begin;
        if (nums[end] == target) return end;
        while (end - begin > 1) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                if (nums[mid] < nums[end] && nums[end] < target) {
                    end = mid;

                } else {
                    begin = mid;
                }
            } else {
                if (nums[mid] > nums[begin] && nums[begin] > target) {
                    begin = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[begin] == target) return begin;
        if (nums[end] == target) return end;
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        search(ints, 0);
    }
}
