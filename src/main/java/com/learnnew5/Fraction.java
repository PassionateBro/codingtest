package com.learnnew5;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-17 10:50
 */
public class Fraction {
    public int[] fraction(int[] cont) {
        //  a + 1/b;
        int a = cont[cont.length - 2];
        int b = cont[cont.length - 1];
        long mum = b;
        long son = a * b + 1;
        for (int i = cont.length - 3; i >= 0; i--) {
            long temp = mum;
            mum = son;
            son = cont[i] * mum + temp;
            int gcd = gcd(mum, son);
            mum /= gcd;
            son /= gcd;
        }
        int gcd = gcd(mum, son);
        mum /= gcd;
        son /= gcd;
        return new int[]{(int) son, (int) mum};
    }

    private int gcd(long a, long b) {
        if (b == 0) {
            return (int) a;
        }
        return gcd(b, a % b);
    }
}
