package com.learnnew5;

import java.util.HashMap;

/**
 * @describtion: 1852. 每个子数组的数字种类数
 * @author: CaiJm
 * @Date: 2022-02-16 13:36
 */
public class DistinctNumbers {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length, size = 0;
        int[] aux = new int[100_001];
        for (int i = 0; i < k; i++) {
            if (aux[nums[i]] == 0) size++;
            aux[nums[i]]++;
        }
        int[] ans = new int[n - k + 1];
        ans[0] = size;
        for (int j = k, i = 0; j < n; j++) {
            if (aux[nums[j]]++ == 0) size++;
            if (--aux[nums[i]] == 0) size--;
            ans[++i] = size;
        }
        return ans;
    }
}
