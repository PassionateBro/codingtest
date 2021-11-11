package com.learn2;

/**
 * @describtion: 1299. 将每个元素替换为右侧最大元素
 * @author: CaiJm
 * @Date: 2021-10-27 11:08
 */
public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int a = arr[i];
            arr[i] = max;
            max = Math.max(a, max);
        }
        return arr;
    }
}
