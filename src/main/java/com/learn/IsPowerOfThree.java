package com.learn;

/**
 * @describtion: 326. 3的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * @author: CaiJm
 * @Date: 2021-09-18 10:11
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467%n == 0;
    }
}
