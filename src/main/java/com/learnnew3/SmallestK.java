package com.learnnew3;

import java.util.Arrays;

/**
 * @describtion: 面试题 17.14. 最小K个数
 * @author: CaiJm
 * @Date: 2022-01-19 9:36
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k - 1);
    }
}
