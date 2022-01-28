package com.learnnew4;

/**
 * @describtion: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author: CaiJm
 * @Date: 2022-01-26 13:44
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int begin = 0, end = nums.length - 1;
        int mid;
        while (end - begin > 1) {
            if (nums[begin] == target && nums[end] == target) break;
            mid = (begin + end) / 2;
            if (nums[mid] >= target && nums[end] != target) {
                end = mid;
            }
            if (nums[mid] <= target && nums[begin] != target) {
                begin = mid;
            }
        }
        while (begin > 0 && nums[begin - 1] == target) {
            begin--;
        }
        while (end < nums.length - 2 && nums[end + 1] == target) {
            end++;
        }
        if (nums[begin] != target) {
            begin++;
        }
        if (nums[end] != target) {
            end--;
        }
        if (begin >= 0 && begin < nums.length) {
            if (nums[begin] == target) return new int[]{begin, end};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,7,7,8,8,10};
        searchRange(a, 6);
    }
}
