package com.learn2;

/**
 * @describtion: 面试题 10.03. 搜索旋转数组
 * @author: CaiJm
 * @Date: 2021-12-10 17:03
 */
public class Search {
    public static int search(int[] arr, int target) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = left + right / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[left] == target) return left;
        if (arr[right] == target) return right;
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        search(ints,5);
    }
}
