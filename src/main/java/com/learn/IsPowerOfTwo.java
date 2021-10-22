package com.learn;

/**
 * @describtion: 231. 2 的幂
 * @author: CaiJm
 * @Date: 2021-10-22 11:17
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
