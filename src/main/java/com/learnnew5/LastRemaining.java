package com.learnnew5;

/**
 * @describtion: 剑指 Offer 62. 圆圈中最后剩下的数字
 * @author: CaiJm
 * @Date: 2022-02-18 10:59
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
