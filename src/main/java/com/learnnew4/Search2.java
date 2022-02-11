package com.learnnew4;

/**
 * @describtion: 81. 搜索旋转排序数组 II
 * @author: CaiJm
 * @Date: 2022-02-07 17:07
 */
public class Search2 {
    public static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < nums[r]) {
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            } else if (nums[mid] > nums[r]) {
                if (nums[mid] > target && target >= nums[l]) r = mid - 1;
                else l = mid + 1;
            } else r--;
        }
        return false;
    }

    public static void main(String[] args) {
        search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}, 2);
    }
}
