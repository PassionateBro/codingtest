package com.learnnew5;

/**
 * @describtion: 剑指 Offer 14- I. 剪绳子
 * @author: CaiJm
 * @Date: 2022-02-18 9:56
 */
public class CuttingRope {
    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int x = 3;
        int temp = n % x;
        int p = (int) Math.pow(x, (n / x) - 1);
        return Math.max((x + temp) * p, p * x * temp);
    }
}
