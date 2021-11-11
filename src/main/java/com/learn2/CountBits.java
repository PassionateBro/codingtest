package com.learn2;

/**
 * @describtion: 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * @author: CaiJm
 * @Date: 2021-10-27 11:14
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] ints = new int[n + 1];
        for (int i = 1; i <= n;) {
            ints[i] = ints[i >> 1] + (i++ % 2);
        }
        return ints;
    }
}
