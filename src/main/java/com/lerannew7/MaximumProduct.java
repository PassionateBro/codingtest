package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-08 14:19
 */
public class MaximumProduct {
    public double myPow(double x, int n) {
        if (n == 0) return 1.d;
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        double b = x;
        while (n > 0) {
            if ((n & 1) == 1) res *= res * b;
            b *= b;
            n >>= 1;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(-2 >> 1);
    }
}
