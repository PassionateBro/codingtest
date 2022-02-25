package com.learnnew5;

/**
 * @describtion: 剑指 Offer 16. 数值的整数次方
 * @author: CaiJm
 * @Date: 2022-02-15 13:47
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(0 & 1);
        System.out.println(1 & 1);
        System.out.println(2 & 1);
        System.out.println(3 & 1);
        System.out.println(8 >> 1);
    }

}
