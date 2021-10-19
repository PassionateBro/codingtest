package com.learn;

/**
 * @describtion: 剑指 Offer II 069. 山峰数组的顶部
 * @author: CaiJm
 * @Date: 2021-10-14 9:26
 */
public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (right - left > 1) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
