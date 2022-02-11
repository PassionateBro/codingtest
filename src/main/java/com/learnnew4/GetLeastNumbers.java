package com.learnnew4;

import java.util.Arrays;

/**
 * @describtion: 剑指 Offer 40. 最小的k个数
 * @author: CaiJm
 * @Date: 2022-02-11 10:24
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = Arrays.copyOfRange(arr, 0, k);
        return res;
    }
}
