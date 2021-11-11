package com.learn2;

/**
 * @describtion: 912. 排序数组
 * @author: CaiJm
 * @Date: 2021-11-02 17:01
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    void qSort(int[] arr, int s, int e) {
        int l = s, r = e;
        if (l < r) {
            int temp = arr[l];
            while (l < r) {
                while (l < r && arr[r] >= temp) r--;
                if (l < r) arr[l] = arr[r];
                while (l < r && arr[l] < temp) l++;
                if (l < r) arr[r] = arr[l];
            }
            arr[l] = temp;
            qSort(arr, s, l);
            qSort(arr, l + 1, e);
        }
    }
}
